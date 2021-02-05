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

        String catBrandy = request.getParameter("Brandy");
        String catBourbon = request.getParameter("Bourbon");
        String catWhiskey = request.getParameter("Whiskey");
        String catFruity = request.getParameter("Fruity");
        String catDesert = request.getParameter("Desert");

        List<String> newDrinkCategoryList = new ArrayList<>();

        if(catBrandy != null){
            newDrinkCategoryList.add(catBrandy);
        }
        if(catBourbon != null){
            newDrinkCategoryList.add(catBourbon);
        }
        if(catWhiskey != null){
            newDrinkCategoryList.add(catWhiskey);
        }
        if(catFruity != null){
            newDrinkCategoryList.add(catFruity);
        }
        if(catDesert != null){
            newDrinkCategoryList.add(catDesert);
        }


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
        }


        if(imageUrl.isEmpty()){
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

        long thisDrinkIdJustMade = DaoFactory.getDrinksDao().getDrinkIdByName(drink.getName());

        List<Integer> categoryIds = new ArrayList<>();
        for(String category : newDrinkCategoryList) {
            categoryIds.add(DaoFactory.getDrinksDao().getCategoryId(category));
        }

        for(int id : categoryIds){
            DaoFactory.getDrinksDao().giveDrinkACategory(thisDrinkIdJustMade, id);
        }
        response.sendRedirect("/drinks");
    }
}
