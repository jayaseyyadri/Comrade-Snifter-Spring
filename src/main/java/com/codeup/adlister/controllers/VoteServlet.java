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

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        long currentViewingDrinkIdToVoteOn =  (long) session.getAttribute("viewingDrink");
        User creator = DaoFactory.getUsersDao().getDrinkCreator(currentViewingDrinkIdToVoteOn);
        session.setAttribute("creatorName", creator.getUsername());
        session.setAttribute("creatorImage", creator.getImage());

        Drink thisDrink = DaoFactory.getDrinksDao().getDrink(currentViewingDrinkIdToVoteOn);

        if(Integer.parseInt(request.getParameter("vote")) > 0) {
            thisDrink.setVotes(thisDrink.getVotes() + 1);
        } else {
            thisDrink.setVotes(thisDrink.getVotes() - 1);
        }

        DaoFactory.getDrinksDao().updateThisDrinksVotes(thisDrink.getVotes(), thisDrink.getId());

        response.sendRedirect("/show");
    }

}