package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.comment.Comment;
import com.econovation.tcono.domain.post.Post;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class CommentDeleteRequestDto {
    private Long userId;
    private Long postId;
    private Long commentId;


    @Builder
    public CommentDeleteRequestDto(Long userId, Long postId, Long commentId){
        this.userId=userId;
        this.postId=postId;
        this.commentId=commentId;
    }
}
