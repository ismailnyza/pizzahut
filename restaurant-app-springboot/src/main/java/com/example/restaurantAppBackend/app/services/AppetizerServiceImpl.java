package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.Repositories.AppetizerRepository;
import com.example.restaurantappBackend.app.model.Appetizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppetizerServiceImpl implements AppetizerService{
    private final AppetizerRepository appetizerRepository;

    public AppetizerServiceImpl(AppetizerRepository appetizerRepository){ this.appetizerRepository = appetizerRepository ;}

    @Override
    public Appetizer findAppetizer(Integer dishid) {
        return appetizerRepository.findAppetizerByDishid(dishid);
    }

    @Override
    public List<Appetizer> findAllAppetizers() {
        return appetizerRepository.findAll();
    }

    @Override
    public List<Appetizer> saveAllAppetizer(List<Appetizer> appetizerList) {
        return appetizerRepository.saveAll(appetizerList);
    }

    @Override
    public Page<Appetizer> paginatedFindAll(int pageNo, int pageSize, String sortType) {
        Pageable pageable = PageRequest.of(pageNo-1 , pageSize , Sort.by(sortType));
        return this.appetizerRepository.findAll(pageable);
    }
}
