package com.lemin.test.dao.repositories;
import com.lemin.test.dao.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT p.id, p.nom, p.password,p.email,u.lib FROM UserEntity p JOIN UserRoleEntity t ON p.id = t.idUser JOIN RoleEntity u ON t.idRole=u.id")
    List<Object[]> findAllWithRole();

}
