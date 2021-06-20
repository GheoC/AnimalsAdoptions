package com.PentaStagiu.project.Service;

import com.PentaStagiu.project.Model.Adapters.CatAdapter;
import com.PentaStagiu.project.Model.CatDTO;
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

    public void addCat(CatDTO catDTO)
    {
        if (catDTO.getName()==null || catDTO.getPhotoUrl()==null)
        {
            throw new RuntimeException("Cat must have a name and a photo");
        }

        catRepository.save(CatAdapter.fromDto(catDTO));
    }

    public List<CatDTO> findAll()
    {
        List<Cat> catList =catRepository.findAll();
        return CatAdapter.toListDto(catList);
    }

    //replaced by findCatById
    public CatDTO findCatByName(String name)
    {
        return CatAdapter.toDto(catRepository.findCatByName(name));
    }

    public CatDTO findCatById(Integer id)
    {
        return CatAdapter.toDto(catRepository.findCatById(id));
    }

    public void updateCat(Integer id, CatDTO catDTO)
    {
        Cat catToSave = catRepository.findCatById(id);
        catToSave.setName(catDTO.getName())
                .setUrl(catDTO.getPhotoUrl());
        catRepository.save(catToSave);
    }

    public void deleteCat(Integer id)
    {
        catRepository.delete(catRepository.findCatById(id));
    }
}
