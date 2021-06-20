package com.PentaStagiu.project.api.Controllers;

import com.PentaStagiu.project.Repository.Cats.Cat;
import com.PentaStagiu.project.Service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/v1/cats")
public class CatController
{
    private final CatService catService;


    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity getAllCats()
    {
        List<Cat> catList = catService.findAll();
        return ResponseEntity.ok(catList);
    }

    @PostMapping
    public void addCat(@RequestBody Cat cat)
    {
        catService.addCat(cat);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Cat> getCatByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(catService.findCatByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cat> getCatByName(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(catService.findCatById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cat> updateCat(@PathVariable("id") Integer id, @RequestBody Cat cat)
    {
        catService.updateCat(id,cat);
        return ResponseEntity.ok(catService.findCatById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable("id") Integer id)
    {
        catService.deleteCat(id);
    }


}
