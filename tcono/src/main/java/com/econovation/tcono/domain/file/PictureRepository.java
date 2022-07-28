package com.econovation.tcono.domain.file;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    @Query("Select f from Picture f where f.post.id=:postId")
    List<Picture> findByPost(@Param("postId") Long postId);
}
