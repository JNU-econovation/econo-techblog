package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.comment.Comment;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentResponseDto {
    private Long commentId;//comment Id 정보
    private Long userId;
    private Long postId;
    private String content;
    private int parent;
    private int seq;

    @Builder
    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.userId=comment.getUserId();
        this.postId = comment.getPost().getId();
        this.content = comment.getContent();
        this.parent = comment.getParent();
        this.seq=comment.getSeq();
    }
}
