package com.lemin.test.dao.repositories;

import com.lemin.test.dao.entities.UserCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Command extends JpaRepository<UserCommandEntity,Integer> {
}
