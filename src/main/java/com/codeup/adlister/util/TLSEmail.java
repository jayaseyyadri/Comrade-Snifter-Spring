package com.codeup.adlister.util;

import com.codeup.adlister.util.EmailUtil;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.ServletException;

//Encrypts & delivers mail securely
public class TLSEmail {
    static final String fromEmail = "seyyadrijaya@gmail.com"; //requires valid gmail id
    static final String password = "xkcihmzoughipmqf"; // correct password for gmail id
    final String toEmail = "will.tisdale.31@gmail.com"; // can be any email id

    /**
     * Outgoing Mail (SMTP) Server
     * requires TLS or SSL: smtp.gmail.com (use authentication)
     * Use Authentication: Yes
     * Port for TLS/STARTTLS: 587
     */
    public static void sendEmail(
            final String toEmail, String userName) throws ServletException, IOException  // can be any email id
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "465"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject", "Hello " + userName + " your new password is "+ Password.randomGen() +" please go to http://localhost:8080/newPassword");
        System.out.println("Email Sent");
    }


}

