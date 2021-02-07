package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Drink;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/drinks/create")
public class CreateDrinkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/drinks/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("blankName");
        session.removeAttribute("blankInstructions");
        session.removeAttribute("blankIngredients");

        User user = (User) session.getAttribute("user");
        String imageUrl = request.getParameter("image");
        String name = request.getParameter("name");
        String instructions = request.getParameter("instructions");
        String ingredients = request.getParameter("ingredients");

        String[] categories = request.getParameterValues("drinkCat");

        if (categories == null) {
            session.setAttribute("blankCat", true);
            response.sendRedirect("/drinks/create");
            return;
        }

        List<String> newDrinkCategoryList = new ArrayList<>(Arrays.asList(request.getParameterValues("drinkCat")));

        if(name.isEmpty()){
            session.setAttribute("blankName", true);
            response.sendRedirect("/drinks/create");
            return;
        } else if(instructions.isEmpty()){
            session.setAttribute("blankInstructions", true);
            response.sendRedirect("/drinks/create");
            return;
        } else if(ingredients.isEmpty()){
            session.setAttribute("blankIngredients", true);
            response.sendRedirect("/drinks/create");
            return;
        } else if(imageUrl.isEmpty()){
            imageUrl = "/resources/img/logo.png";
        }


        Drink drink = new Drink(
            user.getId(),
            name,
            instructions,
            ingredients,
            imageUrl
        );
        DaoFactory.getDrinksDao().insert(drink);

        // could not get the id from it by drink.getId() so querying the database for it's id after it is created to then give it categories in the database
        long thisDrinkIdJustMade = DaoFactory.getDrinksDao().getDrinkIdByName(drink.getName());

        List<Integer> categoryIds = new ArrayList<>();
        for(String category : newDrinkCategoryList) {
            categoryIds.add(DaoFactory.getDrinksDao().getCategoryId(category));
        }

        for(int id : categoryIds){
            DaoFactory.getDrinksDao().giveDrinkACategory(thisDrinkIdJustMade, id);
        }
        response.sendRedirect("/profile");
    }
}
