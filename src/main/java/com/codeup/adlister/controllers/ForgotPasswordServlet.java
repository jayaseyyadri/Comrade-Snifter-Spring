package com.codeup.adlister.controllers;

import com.codeup.adlister.util.Password;
import com.codeup.adlister.util.TLSEmail;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = "/forgot")
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/users/forgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userNameNotInRecord", false);

        String userName = request.getParameter("forgotPassword");
        User user = DaoFactory.getUsersDao().findByUsername(userName);

        if (user != null) {
            System.out.println(" Email " + user.getEmail());
            TLSEmail.sendEmail(user.getEmail(), user.getUsername());
            String passwordGen = Password.getThePassword().get(0);
            user.setPassword(passwordGen);
            DaoFactory.getUsersDao().updateUserPassword(userName, Password.hash(passwordGen));
            request.getRequestDispatcher("/WEB-INF/users/emailWasSent.jsp").forward(request, response);
        } else {
            session.setAttribute("userNameNotInRecord", true);
            response.sendRedirect("/forgot");
        }
    }
}
