package com.lemin.test.dao.repositories.crud;

import com.lemin.test.dao.entities.LivraireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LRepository extends JpaRepository<LivraireEntity,Integer> {
}
