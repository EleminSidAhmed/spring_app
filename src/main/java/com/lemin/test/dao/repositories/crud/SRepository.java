package com.lemin.test.dao.repositories.crud;

import com.lemin.test.dao.entities.HStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SRepository extends JpaRepository<HStatusEntity,Integer> {
}
