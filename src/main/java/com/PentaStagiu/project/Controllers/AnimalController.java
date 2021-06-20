package com.PentaStagiu.project.Controllers;

import com.PentaStagiu.project.Model.Animal;
import com.PentaStagiu.project.Repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController
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
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal)
    {
        if (animal ==null && animal.getName()==null && animal.getPhotoUrl()==null)
        {
            return  ResponseEntity.badRequest().body(animal);
        }
        AnimalStore.available.add(animal);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name= "name") String name, @RequestBody Animal updatedAnimal)
    {
        for (Animal a: AnimalStore.available)
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
        for (Animal a: AnimalStore.available)
        {
            if (a.getName().equals(name))
            {
                AnimalStore.available.remove(a);
                break;
            }
        }
    }

}
