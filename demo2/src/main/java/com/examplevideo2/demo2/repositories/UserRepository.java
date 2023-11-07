package com.examplevideo2.demo2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examplevideo2.demo2.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
   
    Optional<UserEntity> findByUsername(String username);
   
    @Query("select u from UserEntity u where u.username = ?1")
    Optional<UserEntity> getName(String username);
}
