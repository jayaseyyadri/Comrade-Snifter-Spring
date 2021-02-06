package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Drink;
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

@WebServlet(name="EditProfileServlet",urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }

            req.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(req,resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String editUserName = req.getParameter("editUsername");
        User currentUser = (User)session.getAttribute("user");

        String editPassword = req.getParameter("editPassword");
        String editEmailAddress = req.getParameter("editEmailAddress");
        String editProfilePic = req.getParameter("profilePic");

        //if either is empty set its value to get it from db
        if (editUserName.isEmpty()){
            editUserName = currentUser.getUsername();
            session.setAttribute("UsernameExists",false);
        } else if(Validation.userNameExists(DaoFactory.getUsersDao().currentUsernames(),editUserName)){
            session.setAttribute("UsernameExists",true);
            resp.sendRedirect(("/editProfile"));
            return;
        }

        if (editPassword.isEmpty()) {
            editPassword = currentUser.getPassword();
        } else if (!Validation.goodQualityPassword(editPassword)){
            session.setAttribute("poorQualityPassword", true);
            resp.sendRedirect("/editProfile");
            return;
        } else {
            editPassword=Password.hash(editPassword);
        }

        if (editEmailAddress.isEmpty()){
            editEmailAddress = currentUser.getEmail();
        }


        User updatedUserInformation = new User (
            currentUser.getId(),
            editUserName,
            editEmailAddress,
            editPassword,
            editProfilePic
        );

        DaoFactory.getUsersDao().updateUserInformation(updatedUserInformation);
        session.removeAttribute("user");
        session.setAttribute("user", updatedUserInformation);
        resp.sendRedirect("/profile");
    }
}
