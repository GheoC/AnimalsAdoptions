package com.PentaStagiu.project.Service;

import com.PentaStagiu.project.Model.Adapters.AnimalAdapter;
import com.PentaStagiu.project.Model.Adapters.AnimalShelterAdapter;
import com.PentaStagiu.project.Model.AnimalShelterDTO;
import com.PentaStagiu.project.Repository.Shelter.AnimalShelter;
import com.PentaStagiu.project.Repository.Shelter.AnimalShelterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalShelterService
{
    private final AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalShelterDTO getShelter(Integer id)
    {
        return AnimalShelterAdapter.toDto(animalShelterRepository.getById(id));
    }

    public AnimalShelterDTO createShelter(AnimalShelterDTO shelterDTO)
    {
        AnimalShelter animalShelter = AnimalShelterAdapter.fromDto(shelterDTO);
         return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));
    }

    public List<AnimalShelterDTO> getAllShelters()
    {
        List<AnimalShelter> animalShelters = animalShelterRepository.findAll();

        return animalShelters.stream().map(animalShelter -> AnimalShelterAdapter.toDto(animalShelter)).collect(Collectors.toList());

    }

    public AnimalShelterDTO updateShelter(Integer id, AnimalShelterDTO shelterDTO)
    {
        AnimalShelter animalShelter = animalShelterRepository.getById(id);

        animalShelter.setName(shelterDTO.getName())
                .setAddress(shelterDTO.getAddress())
                .setAnimals(AnimalAdapter.fromDto(shelterDTO.getAnimals()));

        return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));
    }

    public void deleteShelter(Integer id)
    {
        animalShelterRepository.deleteById(id);
    }
}
