package com.PentaStagiu.project.api.Controllers;

import com.PentaStagiu.project.Model.AnimalDTO;
import com.PentaStagiu.project.Repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalControllerBasicCrud
{
    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name",required = false) String ownerName)
    {
        String name = ownerName == null ? " world" : ownerName;

        String hello = "Hello "+name;
        return ResponseEntity.ok(hello);
    }

    @GetMapping()
    public ResponseEntity getAvailableAnimals()
    {
        return ResponseEntity.ok(AnimalStore.available);
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> addAnimal(@RequestBody AnimalDTO animal)
    {
        if (animal ==null && animal.getName()==null && animal.getPhotoUrl()==null)
        {
            return  ResponseEntity.badRequest().body(animal);
        }
        AnimalStore.available.add(animal);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name= "name") String name, @RequestBody AnimalDTO updatedAnimal)
    {
        for (AnimalDTO a: AnimalStore.available)
        {
            if (a.getName().equals(name))
            {
                AnimalStore.available.remove(a);
                AnimalStore.available.add(updatedAnimal);
                break;
            }
        }
    }

    @DeleteMapping("/{name}")
    public void deleteAnima(@PathVariable(name = "name") String name)
    {
        for (AnimalDTO a: AnimalStore.available)
        {
            if (a.getName().equals(name))
            {
                AnimalStore.available.remove(a);
                break;
            }
        }
    }

}
