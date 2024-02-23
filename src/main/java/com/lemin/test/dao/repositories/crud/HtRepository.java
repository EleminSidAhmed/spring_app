package com.lemin.test.dao.repositories.crud;

import com.lemin.test.admin.dtos.crud.H_type;
import com.lemin.test.dao.entities.HTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HtRepository extends JpaRepository<HTypeEntity,Integer> {
}
