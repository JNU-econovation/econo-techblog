package com.econovation.tcono.domain.post;

import com.econovation.tcono.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.mainCategory= :mainCategory")
    List<Post> findAllByMainCategory(@Param("mainCategory") MainCategory mainCategory, Pageable pageable);

    @Query("select p from Post p where p.Id=:id")
    Optional<Post> findById(@Param("id") Long id);

    List<Post> findByTitleContaining(String keyword, Pageable pageable);
}
