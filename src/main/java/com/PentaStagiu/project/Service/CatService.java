package com.PentaStagiu.project.Service;

import com.PentaStagiu.project.Repository.Cats.Cat;
import com.PentaStagiu.project.Repository.Cats.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService
{

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(Cat cat)
    {
        if (cat.getName()==null || cat.getUrl()==null)
        {
            throw new RuntimeException("Cat must have a name and a photo");
        }
        Cat catToSave = new Cat()
                .setName(cat.getName())
                .setUrl(cat.getUrl());
        catRepository.save(cat);
    }

    public List<Cat> findAll()
    {
        return catRepository.findAll();
    }

    public Cat findCatByName(String name)
    {

        return catRepository.findCatByName(name);

    }

    public Cat findCatById(Integer id)
    {
        return catRepository.findCatById(id);
    }

    public void updateCat(Integer id, Cat cat)
    {
        Cat catToSave = catRepository.findCatById(id);
        catToSave.setName(cat.getName())
                .setUrl(cat.getUrl());
        catRepository.save(catToSave);
    }

    public void deleteCat(Integer id)
    {
        catRepository.delete(findCatById(id));
    }



}
