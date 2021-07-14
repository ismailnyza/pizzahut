package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Entree;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntreeService {
    Entree findEntree(Integer dishid);
    List<Entree> findAlEntrees();
    List<Entree> saveAllEntrees(List<Entree> entreeList);
    Page<Entree> paginatedFindAll(int pageNo , int pageSize , String sortType);
    
}
