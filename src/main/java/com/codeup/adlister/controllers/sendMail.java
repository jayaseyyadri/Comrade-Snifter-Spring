

package com.codeup.adlister.controllers;

import com.codeup.adlister.util.EmailUtil;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.ServletException;

class TLSEmail {
    final String fromEmail = "seyyadrijaya@gmail.com"; //requires valid gmail id
    final String password = "xkcihmzoughipmqf"; // correct password for gmail id
    final String toEmail = "will.tisdale.31@gmail.com"; // can be any email id

    /**
     Outgoing Mail (SMTP) Server
     requires TLS or SSL: smtp.gmail.com (use authentication)
     Use Authentication: Yes
     Port for TLS/STARTTLS: 587
     */
    public static void sendEmail(String host, String port,
        final String fromEmail,  //requires valid gmail id
        final String password, // correct password for gmail id
        final String toEmail)throws ServletException, IOException  // can be any email id
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", "seyyaadrijaya@gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");

    }


}

