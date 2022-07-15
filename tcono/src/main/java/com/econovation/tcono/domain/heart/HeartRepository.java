package com.econovation.tcono.domain.heart;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {

    @Query("SELECT h FROM Heart h WHERE h.userId = :userId AND h.post.Id = :postId")
    Optional<Heart> findHeartByUserIdAndPostid(@Param("userId") Long userId,@Param("postId") Long postId);
//    Heart deleteHeartByUserIdAndPostId(Long userId, Long postId);

}
