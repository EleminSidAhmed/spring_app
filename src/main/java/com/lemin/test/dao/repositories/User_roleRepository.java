package com.lemin.test.dao.repositories;

import com.lemin.test.dao.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_roleRepository extends JpaRepository<UserRoleEntity,Integer> {

}
