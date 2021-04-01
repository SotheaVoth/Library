package com.library;

import com.library.entity.Book;
import java.util.Date;
import static com.library.ui.Ui.enterToMenu;
import static com.library.utils.Util.*;
import static com.library.utils.Validation.DEFAULT_STRING_FORMAT;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        String name;
        String address;
        while(true){
            System.out.println("========= SET UP LIBRARY =========");
            System.out.print("=> Enter Library's Name    : ");
            name = getStringInput(DEFAULT_STRING_FORMAT).toUpperCase();
            if (name.equalsIgnoreCase("false")){continue;}
            System.out.print("=> Enter Library's Address : ");
            address = getStringInput(DEFAULT_STRING_FORMAT).toUpperCase();
            if (address.equalsIgnoreCase("false")){continue;}
            System.out.println("\""+name+"\" Library is already created in \""+address+"\" address successfully on "+new Date());
            break;
        }
        Book[] books= new Book[10];
        enterToMenu(name,address,books);
    }
}
