package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/passwordReset")
public class ResetYourPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        session.setAttribute("emailDoesNotMatch", false);
        session.setAttribute("userNameDoesNotMatch", false);

        String thisUserName = req.getParameter("verifyUsername");
        String thisEmail = req.getParameter("verifyEmailAddress");
        String newPassword = req.getParameter("shouldBeTheJupiterOne");
//        String confirmNewPassword = req.getParameter("confirmNewPassword");

        User user = DaoFactory.getUsersDao().findByUsername(thisUserName);

        if (user == null){
            session.setAttribute("userNameDoesNotMatch", true);
            res.sendRedirect("/newPassword");
            return;
        } else if (!user.getEmail().equals(thisEmail)){
            session.setAttribute("emailDoesNotMatch", true);
            res.sendRedirect("/newPassword");
            return;
        } else if (!newPassword.equals("Jupiter2021!")){
            session.setAttribute("notOurPassword", true);
            res.sendRedirect("/newPassword");
            return;
        }

        session.setAttribute("passwordResetUser", user);
//        user.setPassword(newPassword);
//        System.out.println(user.getUsername());
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//        DaoFactory.getUsersDao().updateUserInformation(user);


        res.sendRedirect("/createYourNewPassword");
    }

}