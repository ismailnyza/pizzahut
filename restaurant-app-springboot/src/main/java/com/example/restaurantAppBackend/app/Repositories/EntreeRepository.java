package com.example.restaurantappBackend.app.Repositories;

import com.example.restaurantappBackend.app.model.Entree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntreeRepository extends JpaRepository<Entree , Integer> {

    Entree findEntreeByDishid(Integer dishid);
    @Override
    List<Entree> findAll();

}
