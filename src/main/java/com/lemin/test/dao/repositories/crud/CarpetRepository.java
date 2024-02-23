package com.lemin.test.dao.repositories.crud;

import com.lemin.test.dao.entities.CarpetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpetRepository extends JpaRepository<CarpetEntity,Integer> {
}
