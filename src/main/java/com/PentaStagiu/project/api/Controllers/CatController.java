package com.PentaStagiu.project.api.Controllers;

import com.PentaStagiu.project.Model.CatDTO;
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
    public ResponseEntity<List<CatDTO>> getAllCats()
    {
        List<CatDTO> catList = catService.findAll();
        return ResponseEntity.ok(catList);
    }

    @PostMapping
    public void addCat(@RequestBody CatDTO catDTO)
    {
        catService.addCat(catDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatDTO> getCatByName(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(catService.findCatById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatDTO> updateCat(@PathVariable("id") Integer id, @RequestBody CatDTO catDTO)
    {
        catService.updateCat(id,catDTO);
        return ResponseEntity.ok(catService.findCatById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable("id") Integer id)
    {
        catService.deleteCat(id);
    }


}
