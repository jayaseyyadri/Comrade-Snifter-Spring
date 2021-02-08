package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute("emailDoesNotMatch", false);
        session.setAttribute("userNameDoesNotMatch", false);

        String thisUserName = request.getParameter("verifyUsername");
        String thisEmail = request.getParameter("verifyEmailAddresponses");
        String newPassword = request.getParameter("shouldBeTheJupiterOne");
        String passwordFetch = Password.getThePassword().get(0);

        User user = DaoFactory.getUsersDao().findByUsername(thisUserName);

        if (user == null) {
            session.setAttribute("userNameDoesNotMatch", true);
            response.sendRedirect("/newPassword");
            return;
        } else if (!user.getEmail().equals(thisEmail)) {
            session.setAttribute("emailDoesNotMatch", true);
            response.sendRedirect("/newPassword");
            return;
        } else if (!newPassword.equals(passwordFetch)) {
            session.setAttribute("notOurPassword", true);
            response.sendRedirect("/newPassword");
            return;
        }

        session.setAttribute("passwordResetUser", user);
        response.sendRedirect("/createYourNewPassword");
    }

}