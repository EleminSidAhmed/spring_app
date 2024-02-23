package com.lemin.test.admin.services.crud;
import com.lemin.test.admin.dtos.crud.HPrixWithTypeName;
import com.lemin.test.admin.dtos.crud.OwnerDetails;
import com.lemin.test.dao.entities.HUserEntity;
import com.lemin.test.dao.repositories.crud.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomersService {
    private final OwnerRepository ownerRepository;

    public CustomersService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    public List<HUserEntity> getAllOwner() {
        return ownerRepository.findAll();
    }

    public Optional<HUserEntity> getOwnerById(Integer id) {
        return ownerRepository.findById(id);
    }

    public HUserEntity createOwner(HUserEntity huserEntity) {
        return ownerRepository.save(huserEntity);
    }

    public HUserEntity updateOwner(Integer id, HUserEntity huserEntity) {
        if (ownerRepository.existsById(id)) {
            huserEntity.setId(id);
            return ownerRepository.save(huserEntity);
        } else {
            return null; // Or throw an exception indicating the resource doesn't exist
        }
    }

    public void deleteowner(Integer id) {
        ownerRepository.deleteById(id);
    }
    public List<OwnerDetails> ownerdetails(Integer id) {
        List<Object[]> result = ownerRepository.ownerDetails(id);

        return result.stream().map(obj -> {
            OwnerDetails owner = new OwnerDetails();
            owner.setId((int) obj[0]);
            owner.setQuantity((int) obj[1]);
            owner.setLib((String) obj[2]);
            owner.setNom((String) obj[3]);
            return owner;
        }).collect(Collectors.toList());
    }

}
