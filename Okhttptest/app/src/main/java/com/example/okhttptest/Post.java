package com.example.okhttptest;

public class Post {
  public  String Name;
  public  String Title;
  public  String Price;
  public  String Photo;

    public Post() {
    }

    public Post(String name, String title, String price, String photo) {
        Name = name;
        Title = title;
        Price = price;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
