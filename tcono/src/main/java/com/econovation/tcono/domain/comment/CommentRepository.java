package com.econovation.tcono.domain.comment;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.web.dto.CommentResponseDto;
import com.econovation.tcono.web.dto.PostListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("select max(c.parent) from Comment c")
    Optional<Integer> findCommentGroup();

    @Query("select max(c.seq) from Comment c where c.parent=:parent")
    Optional<Integer> findCommentsByParentAndSeq(@Param("parent")int Parent);

    @Query("select c from Comment c where c.post=:post")
    List<Comment> findCommentsByPost(@Param("post") Post post);
}