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

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/")
public class LandingPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Drink> allDrinks = DaoFactory.getDrinksDao().all();

        List<Drink> top3 = new ArrayList<>();
        List<Integer> highestVotes = findHighestValues(allDrinks);
        int count = 0;
        while(top3.size() < 3) {
            for (int i = 0; i < allDrinks.size(); i++) {
                if (count > 2) {
                    break;
                }
                if (allDrinks.get(i).getVotes() == highestVotes.get(count)) {
                    top3.add(allDrinks.get(i));
                    count++;
                }
            }
        }
//        for(Drink best : top3){
//            System.out.printf("Drink name: %s, Votes: %d%n", best.getName(), best.getVotes());
//        }


        request.getSession().setAttribute("topDrinks", top3);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }




    private static List<Integer> findHighestValues (List<Drink> list){
        int a = list.get(0).getVotes();
        int b = list.get(1).getVotes();
        int c = list.get(2).getVotes();
        int[] currentVotes = {a, b, c};
        List<Integer> highestVoteCounts = new ArrayList<>();

        for(int i = 3; i < list.size(); i++){
            int num = list.get(i).getVotes();
            int currMin = min(currentVotes);
            if(num > currMin){
                swap(num, currMin, currentVotes);
            }
        }

        for(int x :currentVotes){
            highestVoteCounts.add(x);
        }
        return highestVoteCounts;
    }

    private static int min(int[] list){
        int a = Integer.MAX_VALUE;
        for(int x : list){
            if(x < a){
                a = x;
            }
        }
        return a;
    }

    private static void swap(int num, int currMin, int[] out){
        for(int i = 0; i < out.length; i++){
            if(out[i] == currMin){
                out[i] = num;
                break;
            }
        }
    }

}
