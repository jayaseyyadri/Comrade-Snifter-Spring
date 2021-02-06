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

@WebServlet(name = "ForgotPasswordServlet",urlPatterns = "/forgot")
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/forgotPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("userNameNotInRecord", false);

        String userName = req.getParameter("forgotPassword");
        User user = DaoFactory.getUsersDao().findByUsername(userName);

        if(user!= null) {
            System.out.println(" Email "+ user.getEmail());
            TLSEmail.sendEmail(user.getEmail(), user.getUsername());
            String passwordGen = Password.getThePassword().get(0);
            user.setPassword(passwordGen);
            DaoFactory.getUsersDao().updateUserPassword(userName, Password.hash(passwordGen));
            req.getRequestDispatcher("/WEB-INF/emailWasSent.jsp").forward(req, resp);
        }else{
            session.setAttribute("userNameNotInRecord", true);
            resp.sendRedirect("/forgot");
        }
    }
}
