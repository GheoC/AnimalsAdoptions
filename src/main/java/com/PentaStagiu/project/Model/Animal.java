package com.PentaStagiu.project.Model;

public class Animal {
    private String name;
    private String photoUrl;

    public Animal() {
    }

    public Animal(String name, String photoUrl) {
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Animal setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public void speak()
    {
        System.out.println("Animal speaks");
    }

    protected void walk()
    {

    }
}
