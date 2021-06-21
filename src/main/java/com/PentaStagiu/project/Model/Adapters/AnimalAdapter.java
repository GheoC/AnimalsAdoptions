package com.PentaStagiu.project.Model.Adapters;

import com.PentaStagiu.project.Model.AnimalDTO;
import com.PentaStagiu.project.Model.CatDTO;
import com.PentaStagiu.project.Repository.Animals.Animal;
import com.PentaStagiu.project.Repository.Cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter
{
    public static Animal fromDto(AnimalDTO animalDTO)
    {
        return new Animal()
                .setName(animalDTO.getName())
                .setUrl(animalDTO.getPhotoUrl());
    }

    public static List<Animal> fromDto(List<AnimalDTO> animalDTOList)
    {
        List<Animal> animals = new ArrayList<>();
        animalDTOList.forEach(animalDTO -> animals.add(fromDto(animalDTO)));
        return animals;
    }

    public static AnimalDTO toDto(Animal animal)

    {
        return new AnimalDTO(animal.getId(), animal.getName(), animal.getUrl());
    }

    public static List<AnimalDTO> toListDto(List<Animal> animalList)
    {
        List<AnimalDTO> animalDTOList = new ArrayList<>();
        animalList.forEach(animal -> animalDTOList.add(toDto(animal)));

        return  animalDTOList;
    }
}
