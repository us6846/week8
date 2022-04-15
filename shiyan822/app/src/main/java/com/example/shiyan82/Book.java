package com.example.shiyan82;
public class Book {
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private int category_id;
    public Book(String name,double price,int categoryid){
        this.name=name;
        this.price=price;
        this.category_id=categoryid;
    }
    public Book(int id, String author, double price,  int pages, String name,int category_id) {
        this.id=id;
        this.author=author;
        this.price=price;
        this.pages=pages;
        this.name=name;
        this.category_id=category_id;
    }
    public int getId(){ return id; }
    public String getName(){return  name;}
    public String geyAuthor(){return author;}
    public double getPrice(){ return price;}
    public int getCategoryid(){return  category_id;}

}
