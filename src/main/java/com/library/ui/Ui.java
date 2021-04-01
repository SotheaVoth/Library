package com.library.ui;

import com.jakewharton.fliptables.FlipTableConverters;
import com.library.entity.Book;
import java.util.Scanner;

import static com.library.service.LibraryService.*;
import static com.library.utils.Util.*;
import static com.library.utils.Validation.DEFAULT_NUMBER_FORMAT;

public class Ui {
    private Ui() {
    }

    public static void displayMenu(String libraryName, String address, Book[] books){
        int options;
        System.out.println("========= "+libraryName+" ,"+address+" =========");
        System.out.println("1- Add Book");
        System.out.println("2- Show All Books");
        System.out.println("3- Show Available Books");
        System.out.println("4- Borrow Book");
        System.out.println("5- Return Book");
        System.out.println("6- Exit");
        System.out.println("----------------------------------------");
        while (true){
            System.out.print("-> Choose option(1-6) : ");
            options = getNumberInput(DEFAULT_NUMBER_FORMAT);
            if (options==-1){continue;}
            break;
        }

        switch(options) {
            case 1:
                addBook(libraryName,address,books);
                break;
            case 2:
                showAllBook(libraryName,address,books);
                break;
            case 3:
                showAvailableBooks(libraryName,address,books);
                break;
            case 4:
                borrowBook(libraryName,address,books);
                break;
            case 5:
                returnBook(libraryName,address,books);
                break;
            case 6:
                System.out.println("\n(^-^) Good Bye! (^-^)");
                break;
            default:
                defaultSwitchMethod(libraryName, address,books);
        }
    }
    private static void defaultSwitchMethod(String libraryName, String address, Book[] books){
        System.out.println("INVALID INPUT");
        displayMenu(libraryName, address, books);
    }
    public static void enterToMenu(String libraryName, String address, Book[] books){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press \"ENTER\" to Continues ....");
        scanner.nextLine();
        displayMenu(libraryName, address,books);
    }
    public static void displayTable(int counter, Book[] books){
        String[] header = {"ID", "TITLE", "AUTHOR", "PUBLISHED DATE", "STATUS"};
        String[][] data = new String[counter][5];
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                data[i] = books[i].toArray();
            }
        }
        System.out.println(FlipTableConverters.fromObjects(header,data));
    }
    public static void displayAvailableBook(int counter, Book[] books){
        int count = 0;
        String[] header = {"ID", "TITLE", "AUTHOR", "PUBLISHED DATE", "STATUS"};
        String[][] data = new String[counter][5];
        for (Book book : books) {
            if (book != null) {
                if (book.getStatus().equalsIgnoreCase("available")) {
                    data[count] = book.toArray();
                    count++;
                }
            }
        }
        System.out.println(FlipTableConverters.fromObjects(header,data));
    }
    public static void displayBookInfo(Book[] books,int id,String process){
        System.out.println("Book ID        : "+books[id-1].getId());
        System.out.println("Book Title     : "+books[id-1].getTitle());
        System.out.println("Book Author    : "+books[id-1].getAuthor());
        System.out.println("Published Year : "+books[id-1].getPublishedYear()+" is "+process+" successfully...");
    }
}
