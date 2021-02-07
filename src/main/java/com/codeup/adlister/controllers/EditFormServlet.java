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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/drinks/edit.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Drink currentDrink = DaoFactory.getDrinksDao().getDrink( Long.parseLong(req.getParameter("editThisDrink")));

        session.setAttribute("currentDrinkName", currentDrink.getName());
        session.setAttribute("currentDrinkInstructions", currentDrink.getInstructions());
        session.setAttribute("currentDrinkIngredients", currentDrink.getIngredients());
        int editDrinkId = Integer.parseInt(req.getParameter("editThisDrink"));
        session.setAttribute("editDrinkId", editDrinkId);
        res.sendRedirect("/edit");
    }

}