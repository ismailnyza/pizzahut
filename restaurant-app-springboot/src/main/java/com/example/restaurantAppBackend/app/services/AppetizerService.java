package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Appetizer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppetizerService {
    Appetizer findAppetizer(Integer dishid);
    List<Appetizer> findAllAppetizers();
    List<Appetizer> saveAllAppetizer(List<Appetizer> appetizerList);
    Page<Appetizer> paginatedFindAll(int pageNo , int pageSize , String sortType);
}
