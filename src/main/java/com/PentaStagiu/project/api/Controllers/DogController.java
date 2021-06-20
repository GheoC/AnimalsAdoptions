package com.PentaStagiu.project.api.Controllers;

import com.PentaStagiu.project.Repository.Dog.Dog;
import com.PentaStagiu.project.Service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dogs")
public class DogController
{
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity getAllDogs()
    {
        return ResponseEntity.ok(dogService.findAllDogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable(name = "id") Integer id)
    {
        return ResponseEntity.ok(dogService.findDogById(id));
    }

    @PostMapping()
    void addDog(@RequestBody Dog dog)
    {
        dogService.addDog(dog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable("id") Integer id, @RequestBody Dog dog)
    {
        dogService.updateDog(id,dog);

        return ResponseEntity.ok(dogService.findDogById(id));
    }

    @DeleteMapping("/{id}")

    public void deleteDog(@PathVariable("id") Integer id)
    {
        dogService.deleteDog(id);

    }


}
