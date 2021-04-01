package com.library.service;

import com.library.entity.Book;

import static com.library.ui.Ui.*;
import static com.library.utils.Util.*;
import static com.library.utils.Validation.*;


public class LibraryService {
    private static final String FALSE = "false";
    private static final String UNAVAILABLE = "unavailable";
    private LibraryService() {
    }

    public static void showAllBook(String libraryName, String address, Book[] books){
        boolean isEmpty =true;
        int counter =0;
        System.out.println("\n\n========= ALL BOOKS INFO =========");
        for (Book book : books) {
            if (book != null) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty){
            System.out.println("\t\tNo Book Available\n\n");
        }else {
            for (Book book : books) {
                if (book != null) {
                    counter++;
                }
            }
          displayTable(counter,books);
        }
        enterToMenu(libraryName, address, books);
    }
    public static void addBook(String libraryName, String address, Book[] books){

        Book book = new Book();
        String title;
        String author;
        String publishedYear;
        while (true){
            System.out.println("========= ADD BOOK INFO =========");
            System.out.println("=> Book ID    : "+book.getId());
            System.out.print("=> Enter Book's Name    : ");
            title = getStringInput(DEFAULT_STRING_AND_NUMBER_FORMAT);
            if (title.equalsIgnoreCase(FALSE)){
                continue;
            }
            System.out.print("=> Enter Book Author    :");
            author = getStringInput(DEFAULT_STRING_FORMAT);
            if (author.equalsIgnoreCase(FALSE)){
                continue;
            }
            System.out.print("=> Enter Published Year    :");
            publishedYear = getStringInput(DEFAULT_YEAR_FORMAT);
            if (publishedYear.equalsIgnoreCase(FALSE)){
                continue;
            }
            System.out.println("    Book is added successfully");
            break;
        }

        book.setBook(title,author,publishedYear);
        books[book.getId()-1] = book;
        enterToMenu(libraryName, address, books);
    }
    public static void showAvailableBooks(String libraryName, String address, Book[] books){
        int counter = 0;
        boolean isEmpty = true;
        for (Book book : books) {
            if (book!=null&&book.getStatus().equalsIgnoreCase("available")){
                counter++;
                isEmpty=false;
            }
        }
        if (isEmpty){
            System.out.println("\t\tNo Book Available\n\n");
        }else{
            displayAvailableBook(counter,books);
        }
        enterToMenu(libraryName, address, books);

    }
    public static void borrowBook(String libraryName, String address, Book[] books){
        System.out.print("=> Enter Book ID to Borrow : ");
        int id = getNumberInput(DEFAULT_NUMBER_FORMAT);
        if (id==-1){ enterToMenu(libraryName, address, books); }
        if (books[id-1]!=null){
            if (books[id-1].getStatus().equalsIgnoreCase(UNAVAILABLE)){
                System.out.println("\nbook by this id is unavailable \n");
            }else{
                books[id-1].setStatus(UNAVAILABLE);
                displayBookInfo(books,id,"borrow");
            }
        }else {
            System.out.println("Book ID : "+id+" not Exist…");
        }
        enterToMenu(libraryName, address, books);
    }
    public static void returnBook(String libraryName, String address, Book[] books){
        System.out.print("=> Enter Book ID to Return : ");
        int id = getNumberInput(DEFAULT_NUMBER_FORMAT);
        if (id==-1){ enterToMenu(libraryName, address, books); }
        if (books[id-1].getStatus().equalsIgnoreCase(UNAVAILABLE)){
            books[id-1].setStatus("available");
            displayBookInfo(books,id,"return");
        }else{
            System.out.println("Book ID : "+id+" is failed to return...");
        }
        enterToMenu(libraryName, address, books);
    }
}
