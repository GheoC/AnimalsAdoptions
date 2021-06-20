package com.PentaStagiu.project.Repository.Dog;

import javax.persistence.*;

@Entity
@Table(name="dog")
public class Dog
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String url;

    public Integer getId() {
        return id;
    }

    public Dog setId(Integer id) {
        id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Dog setUrl(String url) {
        this.url = url;
        return this;
    }
}
