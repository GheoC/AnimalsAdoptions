package com.PentaStagiu.project.Model;

public class AnimalDTO {
    private Integer id;
    private String name;
    private String photoUrl;

    public AnimalDTO() {
    }

    public AnimalDTO(Integer id, String name, String photoUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }

    public AnimalDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public AnimalDTO setPhotoUrl(String photoUrl) {
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
