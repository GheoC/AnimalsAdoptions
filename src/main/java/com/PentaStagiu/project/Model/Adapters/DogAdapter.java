package com.PentaStagiu.project.Model.Adapters;

import com.PentaStagiu.project.Model.DogDTO;
import com.PentaStagiu.project.Repository.Dog.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter
{
    public static Dog fromDto(DogDTO dogDTO)
    {
        return new Dog()
                .setName(dogDTO.getName())
                .setUrl(dogDTO.getPhotoUrl());
    }

    public static DogDTO toDto(Dog dog)
    {
     return new DogDTO(dog.getId(), dog.getName(), dog.getUrl());
    }

    public static List<DogDTO> listToDto(List<Dog> dogList)
    {
        List<DogDTO> dogDTOList = new ArrayList<>();
        dogList.forEach(dog -> dogDTOList.add(toDto(dog)));

        return dogDTOList;
    }

}
