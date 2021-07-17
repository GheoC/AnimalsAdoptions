package com.PentaStagiu.project.Service;

import com.PentaStagiu.project.Model.Adapters.AnimalAdapter;
import com.PentaStagiu.project.Model.Adapters.AnimalShelterAdapter;
import com.PentaStagiu.project.Model.AnimalShelterDTO;
import com.PentaStagiu.project.Model.Validations.OnCreate;
import com.PentaStagiu.project.Model.Validations.OnUpdate;
import com.PentaStagiu.project.Repository.Shelter.AnimalShelter;
import com.PentaStagiu.project.Repository.Shelter.AnimalShelterRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class AnimalShelterService {
    private final AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalShelterDTO getShelter(Integer id) {
        animalShelterRepository.findById(id).orElseThrow(() -> new RuntimeException("Shelter not found"));

        return AnimalShelterAdapter.toDto(animalShelterRepository.getById(id));
    }

//    @Validated(OnCreate.class)
    public AnimalShelterDTO createShelter(@Valid AnimalShelterDTO shelterDTO) {
        if (shelterDTO.getId() != null) {
            throw new RuntimeException("Id must be null");
        }
        AnimalShelter animalShelter = AnimalShelterAdapter.fromDto(shelterDTO);
        return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));
    }

//    @Validated(OnUpdate.class)
    public AnimalShelterDTO updateShelter(Integer id, @Valid AnimalShelterDTO shelterDTO) {
        animalShelterRepository.findById(id).orElseThrow(() -> new RuntimeException("Shelter not found"));

        AnimalShelter animalShelter = animalShelterRepository.getById(id);

        animalShelter.setName(shelterDTO.getName())
                .setAddress(shelterDTO.getAddress())
                .setAnimals(AnimalAdapter.fromDto(shelterDTO.getAnimals()));

        return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));
    }

    public void deleteShelter(Integer id) {
        animalShelterRepository.deleteById(id);
    }

    public List<AnimalShelterDTO> getAllShelters() {
        List<AnimalShelter> animalShelters = animalShelterRepository.findAll();

        return animalShelters.stream().map(animalShelter -> AnimalShelterAdapter.toDto(animalShelter)).collect(Collectors.toList());

    }
}
