package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Drink;

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
        List<Long> highestVotes = findHighestValues(allDrinks);

        List<Drink> top3DrinkList = new ArrayList<>();
        long count = 0;
        while(top3DrinkList.size() < 3) {
            for (long i = 0; i < allDrinks.size(); i++) {
                if (count > 2) break;

                long currentDrinkVotes = allDrinks.get((int) i).getVotes();
                long highestVoteToMatch = highestVotes.get((int) count);

                if (currentDrinkVotes == highestVoteToMatch) {
                    top3DrinkList.add(allDrinks.get((int) i));
                    count++;
                }
            }
        }

        request.getSession().setAttribute("drinks", top3DrinkList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }




    private static List<Long> findHighestValues (List<Drink> list){
        long a = list.get(0).getVotes();
        long b = list.get(1).getVotes();
        long c = list.get(2).getVotes();
        long[] startingVotes = {a, b, c};
        List<Long> highestVoteList = new ArrayList<>();

        for(long i = 3; i < list.size(); i++){
            long potential = list.get((int) i).getVotes();
            long currMin = minOf(startingVotes);
            if(potential > currMin){
                swap(potential, currMin, startingVotes);
            }
        }

        for(long x :startingVotes){
            highestVoteList.add(x);
        }
        return highestVoteList;
    }

    private static long minOf(long[] list){
        long currentMin = Long.MAX_VALUE;
        for(long newMin : list){
            if(newMin < currentMin){
                currentMin = newMin;
            }
        }
        return currentMin;
    }

    private static void swap(long newNum,long oldNum, long[] list){
        for(long i = 0; i < list.length; i++){
            if(list[(int) i] == oldNum){
                list[(int) i] = newNum;
                break;
            }
        }
    }

}
