package com.PentaStagiu.project.Repository.Dog;

import com.PentaStagiu.project.Repository.Animals.Animal;

import javax.persistence.*;

@Entity
public class Dog extends Animal
{
    private String size;

    public Dog() {
    }

    public String getSize() {
        return size;
    }

    public Dog setSize(String size) {
        this.size = size;
        return this;
    }
}
