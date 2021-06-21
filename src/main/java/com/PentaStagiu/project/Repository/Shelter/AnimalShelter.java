package com.PentaStagiu.project.Repository.Shelter;

import com.PentaStagiu.project.Repository.Animals.Animal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnimalShelter
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shelter_id")
    List<Animal> animals = new ArrayList<>();

    public AnimalShelter() {
    }

    public Integer getId() {
        return id;
    }

    public AnimalShelter setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelter setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelter setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public AnimalShelter setAnimals(List<Animal> animals) {
        this.animals = animals;
        return this;
    }
}
