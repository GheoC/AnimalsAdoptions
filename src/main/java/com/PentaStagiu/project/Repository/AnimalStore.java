package com.PentaStagiu.project.Repository;

import com.PentaStagiu.project.Model.Animal;
import com.PentaStagiu.project.Model.Cat;
import com.PentaStagiu.project.Model.Dog;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {

    public static final List<Animal> available = new ArrayList<>()
    {
        {
            add(new Dog("Alfi","My name is Alfi"));
            add(new Dog("Max","Name of the dog MAx"));
            add(new Dog("Grivei","My name is Grivei"));
            add(new Cat("Machi","My name is Machi"));
            add(new Cat("Luna","My name is Luna"));
            add(new Cat("Puss'n'Boots", "My name is Puss'n'Boots"));
        }
    };

}
