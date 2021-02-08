package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.UserServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
        if (isAdmin) {
            List<User> users = DaoFactory.getUsersDao().viewUsers();
            List<User> admins = DaoFactory.getUsersDao().viewAdmins(currentUser.getUsername());
            session.setAttribute("allUsers", users);
            session.setAttribute("allAdmins", admins);
            request.getRequestDispatcher("/WEB-INF/viewUsers.jsp").forward(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idToDelete = Long.parseLong(request.getParameter("idToDelete"));
        User currUser = (User) request.getSession().getAttribute("user");

        // need move all drinks from that user to be the current admins' drinks after deletion
        DaoFactory.getDrinksDao().transferOwnershipFromTo(idToDelete, currUser.getId());

        DaoFactory.getUsersDao().deleteUser(idToDelete);
        response.sendRedirect("/users");
    }
}
