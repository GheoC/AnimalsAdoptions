package com.PentaStagiu.project.api.Controllers;

import com.PentaStagiu.project.Model.AnimalDTO;
import com.PentaStagiu.project.Repository.Animals.Animal;
import com.PentaStagiu.project.Service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
public class AnimalsController
{
    private final AnimalService animalService;

    public AnimalsController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    private ResponseEntity<List<AnimalDTO>> getAll()
    {
        return ResponseEntity.ok(animalService.getAll());
    }

}
