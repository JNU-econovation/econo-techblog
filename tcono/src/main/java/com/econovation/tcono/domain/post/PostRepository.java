package com.econovation.tcono.domain.post;

import com.econovation.tcono.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByMainCategory(MainCategory mainCategory);
}
