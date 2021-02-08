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

@WebServlet("/createYourNewPasswordServlet")
public class CreateYourNewPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/yourNewPasswordForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        HttpSession session = request.getSession();

        User passwordResetter = (User) session.getAttribute("passwordResetUser");

        session.setAttribute("newPasswordDoesNotMatch", false);
        session.setAttribute("newPasswordPoorQuality", false);


        if (!newPassword.equals(confirmNewPassword)) {
            session.setAttribute("newPasswordDoesNotMatch", true);
            response.sendRedirect("/createYourNewPassword");
            return;
        } else if (!Validation.goodQualityPassword(newPassword)) {
            session.setAttribute("newPasswordPoorQuality", true);
            response.sendRedirect("/createYourNewPassword");
            return;
        }

        passwordResetter.setPassword(newPassword);
        DaoFactory.getUsersDao().updateUserInformation(passwordResetter);
        response.sendRedirect("/login");
    }

}