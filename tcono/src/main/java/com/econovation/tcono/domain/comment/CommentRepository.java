package com.econovation.tcono.domain.comment;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.web.dto.CommentResponseDto;
import com.econovation.tcono.web.dto.PostListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("select count(c)from Comment c group by c.parent")
    Integer countByParent();

    @Query("select c from Comment c where c.post=:post")
    List<Comment> findCommentsByPost(@Param("post") Post post);
}