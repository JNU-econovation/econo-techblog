package com.econovation.tcono.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentUpdateRequestDto {
    private Long commentId;
    private Long userId;
    private Long postId;

    private String content;

    @Builder
    public CommentUpdateRequestDto(Long commentId,Long userId, Long postId, String content) {
        this.commentId=commentId;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }
}
