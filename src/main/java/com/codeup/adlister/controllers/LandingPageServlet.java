package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Drink;
import com.codeup.adlister.util.Sorter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "")
public class LandingPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Drink> allDrinks = DaoFactory.getDrinksDao().all();
        List<Integer> highestVotes = findHighestValues(allDrinks);

        List<Drink> top3DrinkList = new ArrayList<>();
        int count = 0;
        while (top3DrinkList.size() < 3) {
            for (int i = 0; i < allDrinks.size(); i++) {
                if (count > 2) break;

                int currentDrinkVotes = allDrinks.get(i).getVotes();
                int highestVoteToMatch = highestVotes.get(count);

                if (currentDrinkVotes == highestVoteToMatch) {
                    top3DrinkList.add(allDrinks.get(i));
                    count++;
                }
            }
        }
        // left to right on landing page, highest votes to lowest votes
        request.getSession().setAttribute("drinks", Sorter.sortDrinkByVotes(top3DrinkList));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


    private static List<Integer> findHighestValues(List<Drink> list) {
        int a = list.get(0).getVotes();
        int b = list.get(1).getVotes();
        int c = list.get(2).getVotes();
        int[] startingVotes = {a, b, c};
        List<Integer> highestVoteList = new ArrayList<>();

        for (int i = 3; i < list.size(); i++) {
            int potential = list.get(i).getVotes();
            int currMin = minOf(startingVotes);
            if (potential > currMin) {
                swap(potential, currMin, startingVotes);
            }
        }

        for (int x : startingVotes) {
            highestVoteList.add(x);
        }
        return highestVoteList;
    }

    private static int minOf(int[] list) {
        int currentMin = Integer.MAX_VALUE;
        for (int newMin : list) {
            if (newMin < currentMin) {
                currentMin = newMin;
            }
        }
        return currentMin;
    }

    private static void swap(int newNum, int oldNum, int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == oldNum) {
                list[i] = newNum;
                break;
            }
        }
    }

}
