package com.PentaStagiu.project.Repository.Cats;

import com.PentaStagiu.project.Repository.Animals.Animal;

import javax.persistence.*;

@Entity
public class Cat extends Animal
{
    private String purrLevel;

    public Cat() {
    }

    public String getPurrLevel() {
        return purrLevel;
    }

    public Cat setPurrLevel(String purrLevel) {
        this.purrLevel = purrLevel;
        return this;
    }
}
