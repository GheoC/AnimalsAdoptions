package com.PentaStagiu.project.Service;

import com.PentaStagiu.project.Model.Adapters.AnimalAdapter;
import com.PentaStagiu.project.Model.AnimalDTO;
import com.PentaStagiu.project.Repository.Animals.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalDTO> getAll()
    {
        return AnimalAdapter.toListDto(animalRepository.findAll());

    }
}
