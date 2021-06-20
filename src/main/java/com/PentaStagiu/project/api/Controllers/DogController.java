package com.PentaStagiu.project.api.Controllers;

import com.PentaStagiu.project.Model.DogDTO;
import com.PentaStagiu.project.Service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/dogs")
public class DogController
{
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<DogDTO>> getAllDogs()
    {
        return ResponseEntity.ok(dogService.findAllDogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogDTO> getDogById(@PathVariable(name = "id") Integer id)
    {
        return ResponseEntity.ok(dogService.findDogById(id));
    }

    @PostMapping()
    public void addDog(@RequestBody DogDTO dogDTO)
    {
        dogService.addDog(dogDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DogDTO> updateDog(@PathVariable("id") Integer id, @RequestBody DogDTO dogDTO)
    {
        dogService.updateDog(id,dogDTO);

        return ResponseEntity.ok(dogService.findDogById(id));
    }

    @DeleteMapping("/{id}")

    public void deleteDog(@PathVariable("id") Integer id)
    {
        dogService.deleteDog(id);

    }


}
