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

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();

        long currentViewingDrinkIdToVoteOn =  (long) session.getAttribute("viewingDrink");

        Drink thisDrink = DaoFactory.getDrinksDao().getDrink(currentViewingDrinkIdToVoteOn);

        System.out.printf("Current Votes for drink %s : %d%n", thisDrink.getName(), thisDrink.getVotes());

        if(Long.parseLong(req.getParameter("vote")) > 0) {
            thisDrink.setVotes(thisDrink.getVotes() + 1);
        } else {
            thisDrink.setVotes(thisDrink.getVotes() - 1);
        }

        System.out.printf("New Votes for drink %s : %d%n", thisDrink.getName(), thisDrink.getVotes());

        DaoFactory.getDrinksDao().updateThisDrinksVotes(thisDrink.getVotes(), thisDrink.getId());


        session.removeAttribute("viewingDrink");
        res.sendRedirect("/drinks");
    }

}