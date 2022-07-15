package com.econovation.tcono.domain.post;

import com.econovation.tcono.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
=======

import java.util.List;


>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByMainCategory(MainCategory mainCategory);
}
