package com.econovation.tcono.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    List<User> findByUserName(@Param("userName") String userName);
<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/domain/user/UserRepository.java
    Optional<User> findByuserEmail(String userEmail);
=======

    @Query("SELECT u FROM User u WHERE u.userEmail = :userEmail")
    Optional<User> findByUserEmail(String userEmail);
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/blog/econovation/tcono/domain/user/UserRepository.java

}
