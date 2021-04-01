package com.library.entity;

import lombok.Data;
@Data
public class Book {
    static int numberOfObject =1;
    private int id;
    private String title;
    private String author;
    private String publishedYear;
    private String status;


    public Book() {
        this.id = numberOfObject++;
    }
    public void setBook(String title, String author,String publishedYear){
        this.title = title;
        this.author = author;
        this.status = "available";
        this.publishedYear = publishedYear;
    }
    public String[] toArray(){
        return new String[]{String.valueOf(this.id), this.title, this.author, this.publishedYear, this.status};
    }
}
