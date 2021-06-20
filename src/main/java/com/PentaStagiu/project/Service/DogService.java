package com.PentaStagiu.project.Service;

import com.PentaStagiu.project.Model.Adapters.DogAdapter;
import com.PentaStagiu.project.Model.DogDTO;
import com.PentaStagiu.project.Repository.Dog.Dog;
import com.PentaStagiu.project.Repository.Dog.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<DogDTO> findAllDogs() {
        return DogAdapter.listToDto(dogRepository.findAll());
    }

    public void addDog(DogDTO dogDTO) {
        if (dogDTO.getName() == null || dogDTO.getPhotoUrl() == null) {
            throw new RuntimeException("Dog need to have some atributes");
        }

        dogRepository.save(DogAdapter.fromDto(dogDTO));
    }

    public DogDTO findDogById(Integer id) {
        return DogAdapter.toDto(dogRepository.findDogById(id));
    }

    public void updateDog(Integer id, DogDTO dogDTO) {
        Dog dogToSave = dogRepository.findDogById(id);
        dogToSave
                .setName(dogDTO.getName())
                .setUrl(dogDTO.getPhotoUrl());

        dogRepository.save(dogToSave);
    }

    public void deleteDog(Integer id)
    {
        Dog dog = dogRepository.findDogById(id);
        dogRepository.delete(dog);
    }

}
