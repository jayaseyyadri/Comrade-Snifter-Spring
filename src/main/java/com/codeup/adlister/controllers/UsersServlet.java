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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
        if(isAdmin) {
            List<User> users = DaoFactory.getUsersDao().viewUsers();
            session.setAttribute("allUsers", users);
            req.getRequestDispatcher("/WEB-INF/viewUsers.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idToDelte = Long.parseLong(req.getParameter("idToDelete"));
        DaoFactory.getUsersDao().deleteUser(idToDelte);
        resp.sendRedirect("/users");
    }
}
