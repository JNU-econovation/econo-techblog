package com.econovation.tcono.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category>findByPost(Post post);
}

