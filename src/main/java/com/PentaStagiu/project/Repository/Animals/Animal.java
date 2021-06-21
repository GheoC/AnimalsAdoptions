package com.PentaStagiu.project.Repository.Animals;

import com.PentaStagiu.project.Repository.Shelter.AnimalShelter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public Animal setUrl(String url) {
        this.url = url;
        return this;
    }
}
