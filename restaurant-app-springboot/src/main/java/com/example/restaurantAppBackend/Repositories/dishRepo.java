package com.example.restaurantappBackend.Repositories;

import com.example.restaurantappBackend.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dishRepo extends JpaRepository<Dish, Long> {

//    @Override
//    Optional<dish> findById(Long userid);

//    @Override
//    List<dish> findAll();


}
