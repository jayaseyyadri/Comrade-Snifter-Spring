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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/drinks/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newName = request.getParameter("newName");
        String newInstructions = request.getParameter("newInstructions");
        String newIngredients = request.getParameter("newIngredients");
        String newImage = request.getParameter("newImage");
        session.removeAttribute("blankNewName");
        session.removeAttribute("blankNewInstructions");
        session.removeAttribute("blankNewIngredients");

        if (newImage.isEmpty()) {
            newImage = "/resources/img/logo.png";
        }

        int editDrinkId = (int) session.getAttribute("editDrinkId");
        User currUser = (User) session.getAttribute("user");
        Drink newDrinkInfo = new Drink(
                currUser.getId(),
                newName,
                newInstructions,
                newIngredients,
                newImage
        );

        DaoFactory.getDrinksDao().edit(editDrinkId, newDrinkInfo);
        session.removeAttribute("editDrinkId");
        response.sendRedirect((String) session.getAttribute("previousPage"));
    }

}