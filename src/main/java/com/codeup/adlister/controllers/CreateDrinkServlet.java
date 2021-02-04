package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Drink;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        User user = (User) request.getSession().getAttribute("user");
        String imageUrl = request.getParameter("image");
        if(imageUrl == null){
            imageUrl = "/img/logo.png";
        }
        Drink drink = new Drink(
            user.getId(),
            request.getParameter("name"),
            request.getParameter("instructions"),
            request.getParameter("ingredients"),
            request.getParameter("image")
        );
        DaoFactory.getDrinksDao().insert(drink);
        response.sendRedirect("/drinks");
    }
}
