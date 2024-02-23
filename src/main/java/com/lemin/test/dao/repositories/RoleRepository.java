package com.lemin.test.dao.repositories;

import com.lemin.test.dao.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {


}
