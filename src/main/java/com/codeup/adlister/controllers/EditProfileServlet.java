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

@WebServlet(name = "EditProfileServlet", urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/users/editProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String editUserName = request.getParameter("editUsername");
        User currentUser = (User) session.getAttribute("user");

        String editPassword = request.getParameter("editPassword");
        String editEmailAddress = request.getParameter("editEmailAddress");
        String editProfilePic = request.getParameter("profilePic");

        //if either is empty set its value to get it from db
        if (editUserName.isEmpty()) {
            editUserName = currentUser.getUsername();
        } else if (Validation.userNameExists(DaoFactory.getUsersDao().currentUsernames(), editUserName)) {

            session.setAttribute("UsernameExists", true);
            response.sendRedirect(("/editProfile"));
            return;
        }

        if (editPassword.isEmpty()) {
            editPassword = currentUser.getPassword();
        } else if (!Validation.goodQualityPassword(editPassword)) {
            session.setAttribute("poorQualityPassword", true);
            response.sendRedirect("/editProfile");
            return;
        } else {
            editPassword = Password.hash(editPassword);
        }

        if (editEmailAddress.isEmpty()) {
            editEmailAddress = currentUser.getEmail();
        }

        if (editProfilePic.isEmpty()) {
            editProfilePic = currentUser.getImage();
        }


        User updatedUserInformation = new User(
                currentUser.getId(),
                editUserName,
                editEmailAddress,
                editPassword,
                editProfilePic
        );

        DaoFactory.getUsersDao().updateUserInformation(updatedUserInformation);
        session.removeAttribute("user");
        session.setAttribute("user", updatedUserInformation);
        response.sendRedirect("/profile");
    }
}
