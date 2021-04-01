package com.library.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String DEFAULT_NUMBER_FORMAT = "[0-9]{1,3}";
    public static final String DEFAULT_YEAR_FORMAT = "[0-9]{4}";
    public static final String DEFAULT_STRING_AND_NUMBER_FORMAT = "[a-zA-Z0-9\\s]{2,25}";
    public static final String DEFAULT_STRING_FORMAT = "[a-zA-Z\\s]{2,25}";
    private Validation() {
    }

    public static boolean validateInput(String str, String inputPattern){
        Pattern pattern = Pattern.compile(inputPattern);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            return true;
        }else{
            System.out.println("INVALID INPUT");
            return false;
        }
    }
}
