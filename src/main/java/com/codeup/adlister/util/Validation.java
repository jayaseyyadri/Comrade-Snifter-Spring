package com.codeup.adlister.util;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public Validation(){}

    public static boolean userNameExists(Set<String> currentUsers, String registerAttemptName){
        return currentUsers.contains(registerAttemptName);
    }

    public static boolean goodQualityPassword(String passwordAttempt){
        int len = passwordAttempt.length();

        if(len < 8 || len > 20) return false;

        Pattern upper = Pattern.compile("\\p{Upper}");
        Pattern lower = Pattern.compile("\\p{Lower}");
        Pattern digit = Pattern.compile("\\d");
        Pattern specialChar = Pattern.compile("\\W");

        Matcher matcherUp = upper.matcher(passwordAttempt);
        Matcher matcherLow = lower.matcher(passwordAttempt);
        Matcher matcherNum = digit.matcher(passwordAttempt);
        Matcher special = specialChar.matcher(passwordAttempt);

        return matcherUp.find()
                && matcherLow.find()
                && matcherNum.find()
                && special.find();
    }

}
