package com.lemin.test.admin.services.crud;

import com.lemin.test.dao.entities.HTypeEntity;
import com.lemin.test.dao.repositories.crud.HtRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService{
    private final HtRepository htRepository;

    public TypeService(HtRepository htRepository) {
        this.htRepository = htRepository;
    }

    public HTypeEntity saveOne(HTypeEntity hType ){
    return htRepository.save(hType);

    }
    public List<HTypeEntity> getAll(){
        return htRepository.findAll();
    }


    public Optional<HTypeEntity> getTypeById(Integer id) {
        return htRepository.findById(id);
    }

    public HTypeEntity updatedtype(Integer id, HTypeEntity updatedtype) {
        if (htRepository.existsById(id)) {
            updatedtype.setId(id);
            return htRepository.save(updatedtype);
        } else {
            return null; // Or throw an exception indicating the resource doesn't exist
        }
    }

    public void deleteType(Integer id) {
        htRepository.deleteById(id);
    }

}
