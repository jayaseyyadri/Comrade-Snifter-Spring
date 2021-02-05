package com.codeup.adlister.util;

public class URIPath {

    public static String findServletPath(String uri){
        String urlPattern = "/";
        if(uri.equals("/WEB-INF/profile.jsp")){
            urlPattern = "/profile";
            return urlPattern;
        } else if(uri.equals("/index.jsp")){
            urlPattern = "/";
            return urlPattern;
        }else if(uri.equals("/WEB-INF/drinks/index.jsp")){
            urlPattern = "/drinks";
            return urlPattern;
        }
        return urlPattern;
    }
}
