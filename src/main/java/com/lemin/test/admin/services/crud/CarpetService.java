package com.lemin.test.admin.services.crud;

import com.lemin.test.dao.entities.CarpetEntity;
import com.lemin.test.dao.repositories.crud.CarpetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarpetService {
    private final CarpetRepository carpetRepository;

    public CarpetService(CarpetRepository carpetRepository) {
        this.carpetRepository = carpetRepository;
    }


    public CarpetEntity saveOne(CarpetEntity carpet ){
        return carpetRepository.save(carpet);

    }
    public List<CarpetEntity> getAll(){
        return carpetRepository.findAll();
    }


    public Optional<CarpetEntity> getCarpeteById(Integer id) {
        return carpetRepository.findById(id);
    }

    public CarpetEntity updatedcarpet(Integer id, CarpetEntity carpet) {
        if (carpetRepository.existsById(id)) {
            carpet.setId(id);
            return carpetRepository.save(carpet);
        } else {
            return null; // Or throw an exception indicating the resource doesn't exist
        }
    }

    public void deleteCarpet(Integer id) {
        carpetRepository.deleteById(id);
    }
}
