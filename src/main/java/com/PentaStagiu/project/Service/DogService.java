package com.PentaStagiu.project.Service;

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

    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public void addDog(Dog dog) {
        if (dog.getName() == null || dog.getUrl() == null) {
            throw new RuntimeException("Dog need to have some atributes");
        }

        Dog dogToSave = new Dog()
                .setName(dog.getName())
                .setUrl(dog.getUrl());

        dogRepository.save(dogToSave);
    }

    public Dog findDogById(Integer id) {
        return dogRepository.findDogById(id);
    }

    public void updateDog(Integer id, Dog dog) {
        Dog dogToSave = dogRepository.findDogById(id);
        dogToSave
                .setName(dog.getName())
                .setUrl(dog.getUrl());

        dogRepository.save(dogToSave);
    }

    public void deleteDog(Integer id)
    {
        Dog dog = dogRepository.findDogById(id);
        dogRepository.delete(dog);
    }

}
