package com.PentaStagiu.project.Repository.Dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

    Dog findDogById(Integer id);
}
