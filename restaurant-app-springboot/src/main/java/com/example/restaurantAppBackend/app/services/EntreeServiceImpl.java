package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.Repositories.EntreeRepository;
import com.example.restaurantappBackend.app.model.Entree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntreeServiceImpl implements EntreeService{
    private final EntreeRepository entreeRepository;

    public EntreeServiceImpl(EntreeRepository entreeRepository){ this.entreeRepository = entreeRepository;}


    @Override
    public Entree findEntree(Integer dishid) {
        return entreeRepository.findEntreeByDishid(dishid);
    }

    @Override
    public List<Entree> findAlEntrees() {
        return entreeRepository.findAll();
    }

    @Override
    public List<Entree> saveAllEntrees(List<Entree> entreeList) {
        return entreeRepository.saveAll(entreeList);
    }

    @Override
    public Page<Entree> paginatedFindAll(int pageNo, int pageSize, String sortType) {
        Pageable pageable = PageRequest.of(pageNo-1 , pageSize , Sort.by(sortType));
        return this.entreeRepository.findAll(pageable);
    }
}
