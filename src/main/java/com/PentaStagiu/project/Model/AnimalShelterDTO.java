package com.PentaStagiu.project.Model;

import com.PentaStagiu.project.Model.Validations.OnCreate;
import com.PentaStagiu.project.Model.Validations.OnUpdate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelterDTO
{

    //discriminator on ID
    //@Null(message = "Id must be null for creation", groups = OnCreate.class)
    //@NotNull(message = "Id must not be null for update", groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "Name is mandatory")
    @Min(value = 3,message = "Name must have at least 3 characters")
    private String name;

    @NotNull(message = "Address is mandatory")
    private String address;

    List<AnimalDTO> animals = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public AnimalShelterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<AnimalDTO> getAnimals() {
        return animals;
    }

    public AnimalShelterDTO setAnimals(List<AnimalDTO> animals) {
        this.animals = animals;
        return this;
    }
}
