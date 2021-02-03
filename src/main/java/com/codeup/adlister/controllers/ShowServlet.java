package com.codeup.adlister.controllers;

import com.codeup.adlister.*;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLDrinksDao;
import com.codeup.adlister.models.Drink;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowServlet", urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("drinkId"));
        long drinkId = Long.parseLong(request.getParameter("drinkId"));
        System.out.println(drinkId);
        Drink drink = DaoFactory.getDrinksDao().getDrink(drinkId);
        request.getSession().setAttribute("drink", drink);
        request.getRequestDispatcher("/WEB-INF/drinks/show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/drinks/show.jsp").forward(request, response);
    }
}