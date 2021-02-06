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

@WebServlet("/createYourNewPassword")
public class CreateYourNewPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/yourNewPasswordForm.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String newPassword = req.getParameter("newPassword");
        String confirmNewPassword = req.getParameter("confirmNewPassword");
        HttpSession session = req.getSession();

        User passwordResetter = (User) session.getAttribute("passwordResetUser");

        session.setAttribute("newPasswordDoesNotMatch", false);
        session.setAttribute("newPasswordPoorQuality", false);


        if (!newPassword.equals(confirmNewPassword)){
            session.setAttribute("newPasswordDoesNotMatch", true);
            res.sendRedirect("/createYourNewPassword");
            return;
        } else if (!Validation.goodQualityPassword(newPassword)){
            session.setAttribute("newPasswordPoorQuality", true);
            res.sendRedirect("/createYourNewPassword");
            return;
        }

        passwordResetter.setPassword(newPassword);
        System.out.println(passwordResetter.getUsername());
        System.out.println(passwordResetter.getEmail());
        System.out.println(passwordResetter.getPassword());
        DaoFactory.getUsersDao().updateUserInformation(passwordResetter);

        res.sendRedirect("/login");
    }

}