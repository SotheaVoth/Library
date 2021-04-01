package com.library.utils;

import java.util.Scanner;

import static com.library.utils.Validation.validateInput;

public class Util {
    private Util() {
    }

    public static int getNumberInput(String pattern){
        String tempString;
        Scanner scanner = new Scanner(System.in);
        tempString = scanner.next();
        if (validateInput(tempString,pattern)){
            return Integer.parseInt(tempString);
        }
        return -1;
    }
    public static String getStringInput(String pattern){
        String tempString;
        Scanner scanner = new Scanner(System.in);
        tempString = scanner.nextLine();
        if (validateInput(tempString,pattern)){
            return tempString;
        }
        return "false";
    }
}
