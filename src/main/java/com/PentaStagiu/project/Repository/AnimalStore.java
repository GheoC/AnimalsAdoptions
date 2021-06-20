package com.PentaStagiu.project.Repository;

import com.PentaStagiu.project.Model.Animal;
import com.PentaStagiu.project.Model.CatDTO;
import com.PentaStagiu.project.Model.DogDTO;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {

    public static final List<Animal> available = new ArrayList<>()
    {
        {
            add(new DogDTO(1, "Alfi","My name is Alfi"));
            add(new DogDTO(2, "Max","Name of the dog MAx"));
            add(new DogDTO(3, "Grivei","My name is Grivei"));
            add(new CatDTO(4, "Machi","My name is Machi"));
            add(new CatDTO(5,"Luna","My name is Luna"));
            add(new CatDTO(6,"Puss'n'Boots", "My name is Puss'n'Boots"));
        }
    };

}
