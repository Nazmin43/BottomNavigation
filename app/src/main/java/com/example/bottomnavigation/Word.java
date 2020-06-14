package com.example.bottomnavigation;

public class Word {
    private String description;
    private int arr;
    public Word(String description, int arr)
    {
        this.description=description;
        this.arr=arr;
    }
    public String getDescription() {
        return description;
    }
    public int getArr(){
        return  arr;
    }
}
