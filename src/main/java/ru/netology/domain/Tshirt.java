package ru.netology.domain;

public class Tshirt extends Product {
    private String author;


    public Tshirt(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
}

