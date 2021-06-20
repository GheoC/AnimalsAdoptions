package com.PentaStagiu.project.Repository.Cats;

import javax.persistence.*;

@Entity
@Table(name = "cat")
public class Cat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;

    public Integer getId() {
        return id;
    }

    public Cat setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Cat setUrl(String url) {
        this.url = url;
        return this;
    }
}
