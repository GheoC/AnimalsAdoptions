package com.PentaStagiu.project.Model.Adapters;

import com.PentaStagiu.project.Model.AnimalShelterDTO;
import com.PentaStagiu.project.Repository.Animals.Animal;
import com.PentaStagiu.project.Repository.Shelter.AnimalShelter;

public class AnimalShelterAdapter
{

    public static AnimalShelter fromDto(AnimalShelterDTO shelterDTO)
    {
        if (shelterDTO.getName().equals(""))
        {
            shelterDTO.setName("Generic shelter");
        }
        return new AnimalShelter()
                .setName(shelterDTO.getName())
                .setAddress(shelterDTO.getAddress())
                .setId(shelterDTO.getId())
                .setAnimals(AnimalAdapter.fromDto(shelterDTO.getAnimals()));
    }



    public static AnimalShelterDTO toDto(AnimalShelter animalShelter)
    {
        return new AnimalShelterDTO()
                .setName(animalShelter.getName())
                .setAddress(animalShelter.getAddress())
                .setId(animalShelter.getId())
                .setAnimals(AnimalAdapter.toListDto(animalShelter.getAnimals()));

    }



}
