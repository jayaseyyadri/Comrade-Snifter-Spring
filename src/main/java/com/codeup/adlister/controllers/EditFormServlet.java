package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Drink;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editForm")
public class EditFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/drinks/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Drink currentDrink = DaoFactory.getDrinksDao().getDrink(Long.parseLong(request.getParameter("editThisDrink")));

        session.setAttribute("currentDrinkName", currentDrink.getName());
        session.setAttribute("currentDrinkInstructions", currentDrink.getInstructions());
        session.setAttribute("currentDrinkIngredients", currentDrink.getIngredients());
        session.setAttribute("currentDrinkImage", currentDrink.getImage());
        int editDrinkId = Integer.parseInt(request.getParameter("editThisDrink"));
        session.setAttribute("editDrinkId", editDrinkId);
        response.sendRedirect("/edit");
    }

}