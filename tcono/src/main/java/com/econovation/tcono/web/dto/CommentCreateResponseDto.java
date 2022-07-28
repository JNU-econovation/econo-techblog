package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.comment.Comment;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentCreateResponseDto {
    private Long commentId;//comment Id 정보
    private String userName;
    private Long postId;
    private String content;
    private int group;

    private String createdDate;
    private int seq;

    @Builder
    public CommentCreateResponseDto(Comment comment, User user){
        this.commentId=comment.getCommentId();
        this.userName=user.getUserName();
        this.postId=comment.getPost().getId();
        this.content= comment.getContent();;
        this.seq=comment.getSeq();
        this.group=comment.getGroup();
    }

}
