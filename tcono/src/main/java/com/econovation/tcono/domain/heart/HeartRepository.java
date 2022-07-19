package com.econovation.tcono.domain.heart;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
    /**
     * 게시물(post)에 특정 회원이 회원(user)이 좋아요(heart)를 눌렀는지?
     * @param userId
     * @Param post
     * @return Optional<Post>
     */
    @Query("select h from Heart h where h.user.id=:userId AND h.post=:post")
    Optional<Heart>findHeartByUserIdAndUserId(@Param("userId") Long userId, @Param("post") Post post);

    /**
     * 게시물(post)에 특정 회원(user)이 한 좋아요(heart)를 삭제
     * @param userId
     * @param post
     */
    @Modifying
    @Query("delete from Heart h where h.user.id=:userId AND h.post=:post")
    Optional<Heart> deleteHeartByUserIdAndPost(@Param("userId") Long userId,@Param("post") Post post);

}
