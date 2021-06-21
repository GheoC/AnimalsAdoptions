package com.PentaStagiu.project.Model.Adapters;

import com.PentaStagiu.project.Model.CatDTO;
import com.PentaStagiu.project.Repository.Cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter
{
    public static Cat fromDto(CatDTO catDTO)
    {
        return (Cat) new Cat()
                .setName(catDTO.getName())
                .setUrl(catDTO.getPhotoUrl());
    }

    public static CatDTO toDto(Cat cat)
    {
     return new CatDTO(cat.getId(), cat.getName(), cat.getUrl());
    }

    public static List<CatDTO> toListDto(List<Cat> catList)
    {
        List<CatDTO> dtoList = new ArrayList<>();
        catList.forEach(cat -> dtoList.add(toDto(cat)));

        return  dtoList;
    }
}
