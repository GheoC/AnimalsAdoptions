package com.PentaStagiu.project.Model;

public class Animal {
    private Integer id;
    private String name;
    private String photoUrl;

    public Animal() {
    }

    public Animal(Integer id, String name, String photoUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
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
