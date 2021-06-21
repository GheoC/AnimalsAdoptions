package com.PentaStagiu.project.api.Controllers;

import com.PentaStagiu.project.Model.Adapters.AnimalShelterAdapter;
import com.PentaStagiu.project.Model.AnimalShelterDTO;
import com.PentaStagiu.project.Service.AnimalShelterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/shelters")
public class AnimalShelterController
{
    private final AnimalShelterService shelterService;

    public AnimalShelterController(AnimalShelterService animalShelterService) {
        this.shelterService = animalShelterService;
    }

    @GetMapping
    private ResponseEntity<List<AnimalShelterDTO>> getAll()
    {
        return ResponseEntity.ok(shelterService.getAllShelters());
    }

    @GetMapping("/{id}")
    private ResponseEntity<AnimalShelterDTO> getShelter(@PathVariable("id") Integer id)
    {

        return ResponseEntity.ok(shelterService.getShelter(id));
    }

    @PostMapping
    private ResponseEntity<AnimalShelterDTO> createShelter(@RequestBody AnimalShelterDTO shelterDTO)
    {
        return ResponseEntity.ok(shelterService.createShelter(shelterDTO));
    }

    @PutMapping("/{id}")
    private ResponseEntity<AnimalShelterDTO> updateShelter(@PathVariable("id")Integer id, @RequestBody AnimalShelterDTO shelterDTO)
    {
        return ResponseEntity.ok(shelterService.updateShelter(id, shelterDTO));
    }

    @DeleteMapping("/{id}")
    private void deleteShelter(@PathVariable("id")Integer id)
    {
        shelterService.deleteShelter(id);
    }

}
