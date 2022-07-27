package com.econovation.tcono.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Long countAllByRole(Role role);

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    List<User> findByUserName(@Param("userName") String userName);

    @Query("SELECT u FROM User u WHERE u.userEmail = :userEmail")
    Optional<User> findByUserEmail(@Param("userEmail") String userEmail);

    @Query("SELECT u FROM User u WHERE u.pinCode = :pinCode")
    Optional<User> findUserByPinCode(@Param("pinCode")String pinCode);

    Page<User> findAll(Pageable pageable);
}
