package com.econovation.tcono.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("Select c from Category c where c.post=:post")
    List<Category>findAllByPost(@Param("post") Post post);
}
