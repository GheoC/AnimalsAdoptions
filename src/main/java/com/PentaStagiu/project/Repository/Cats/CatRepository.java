package com.PentaStagiu.project.Repository.Cats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat,Integer>
{

    Cat findCatByName(String name);

    Cat findCatById(Integer id);

}
