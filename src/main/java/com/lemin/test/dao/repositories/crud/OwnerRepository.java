package com.lemin.test.dao.repositories.crud;

import com.lemin.test.dao.entities.HUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<HUserEntity,Integer> {
    @Query("SELECT t.id, t.quantity, p.lib, u.nom FROM HUserEntity t JOIN HPrixEntity p ON t.idPrix = p.id JOIN UserEntity u ON t.idUser = u.id WHERE t.id = :id")
    List<Object[]> ownerDetails(@Param("id") Integer id);


    @Query("SELECT u FROM HUserEntity u WHERE u.idUser = :userId")
    List<HUserEntity> findByUserId(Long userId);


}
