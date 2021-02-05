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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String newName = req.getParameter("newName");
        String newInstructions = req.getParameter("newInstructions");
        String newIngredients = req.getParameter("newIngredients");
        String newImage = req.getParameter("newImage");
        session.removeAttribute("blankNewName");
        session.removeAttribute("blankNewInstructions");
        session.removeAttribute("blankNewIngredients");

        if(newImage.isEmpty()){
            newImage = "/resources/img/logo.png";
        }

        if(newName.isEmpty()){
            session.setAttribute("blankNewName", true);
            res.sendRedirect("/editForm");
            return;
        } else if(newInstructions.isEmpty()){
            session.setAttribute("blankNewInstructions", true);
            res.sendRedirect("/editForm");
            return;
        } else if(newIngredients.isEmpty()){
            session.setAttribute("blankNewIngredients", true);
            res.sendRedirect("/editForm");
            return;
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
        res.sendRedirect("/drinks");
    }

}