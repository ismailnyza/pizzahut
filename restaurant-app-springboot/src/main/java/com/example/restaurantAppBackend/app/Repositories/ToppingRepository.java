package com.example.restaurantappBackend.app.Repositories;
import com.example.restaurantappBackend.app.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {

    Topping findByToppingid(Integer toppingid);

    @Override
    List<Topping> findAll();


}
