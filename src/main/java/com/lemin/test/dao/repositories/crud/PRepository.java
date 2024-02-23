package com.lemin.test.dao.repositories.crud;

import com.lemin.test.dao.entities.HPrixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PRepository extends JpaRepository<HPrixEntity,Integer> {
    @Query("SELECT p.id, p.prix, p.lib, t.type FROM HPrixEntity p JOIN HTypeEntity t ON p.idType = t.id")
    List<Object[]> findAllWithHType();
}
