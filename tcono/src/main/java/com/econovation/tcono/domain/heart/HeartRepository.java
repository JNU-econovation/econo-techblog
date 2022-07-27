package com.econovation.tcono.domain.heart;

import com.econovation.tcono.domain.post.MainCategory;
import com.econovation.tcono.domain.post.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
    @Query("select h From Heart h where h.userId=:userId and h.post=:post")
    Optional<Heart> findByUserIdAndPost(@Param("userId") Long userId, @Param("post") Post post);


    @Modifying
    @Query("delete from Heart h where h.userId=:userId and h.post=:post")
    void deleteHeartByUserIdAndPostId(@Param("userId") Long userId, @Param("post") Post post);
}
