package com.codeup.adlister.controllers;

import com.codeup.adlister.*;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLDrinksDao;
import com.codeup.adlister.models.Drink;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.URIPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowServlet", urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long drinkId = Long.parseLong(request.getParameter("drinkId"));

        request.getSession().setAttribute("previousPage", URIPath.findServletPath(request.getParameter("currentPage")));
        
        request.getSession().setAttribute("viewingDrink", drinkId);

        Drink drink = DaoFactory.getDrinksDao().getDrink(drinkId);

        User creator = DaoFactory.getUsersDao().getDrinkCreator(drinkId);
        request.setAttribute("creatorName", creator.getUsername());
        request.setAttribute("creatorImage", creator.getImage());

        List<Drink> drinks = new ArrayList<>();
        drinks.add(drink);
        request.getSession().setAttribute("name", drinks.get(0).getName());
        request.getSession().setAttribute("drinks", drinks);
        request.getRequestDispatcher("/WEB-INF/drinks/show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/drinks/show.jsp").forward(request, response);
    }
}
