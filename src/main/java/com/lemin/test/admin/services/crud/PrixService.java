package com.lemin.test.admin.services.crud;

import com.lemin.test.admin.dtos.crud.HPrixWithTypeName;
import com.lemin.test.dao.entities.HPrixEntity;
import com.lemin.test.dao.repositories.crud.PRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrixService {
    private final PRepository pRepository;

    public PrixService(PRepository pRepository) {
        this.pRepository = pRepository;
    }
    public List<HPrixEntity> getAllPrix() {
        return pRepository.findAll();
    }

    public Optional<HPrixEntity> getPrixById(Integer id) {
        return pRepository.findById(id);
    }

    public HPrixEntity createPrix(HPrixEntity hPrixEntity) {
        return pRepository.save(hPrixEntity);
    }

    public HPrixEntity updateHPrixEntity(Integer id, HPrixEntity updatedHPrixEntity) {
        if (pRepository.existsById(id)) {
            updatedHPrixEntity.setId(id);
            return pRepository.save(updatedHPrixEntity);
        } else {
            return null; // Or throw an exception indicating the resource doesn't exist
        }
    }

    public void deletePrix(Integer id) {
        pRepository.deleteById(id);
    }
    public List<HPrixWithTypeName> getAllPrixWithType() {
        List<Object[]> result = pRepository.findAllWithHType();

        return result.stream().map(obj -> {
            HPrixWithTypeName hprixWithType = new HPrixWithTypeName();
            hprixWithType.setId((int) obj[0]);
            hprixWithType.setPrix((Integer) obj[1]);
            hprixWithType.setLib((String) obj[2]);
            hprixWithType.setType((String) obj[3]);
            return hprixWithType;
        }).collect(Collectors.toList());
    }
}
