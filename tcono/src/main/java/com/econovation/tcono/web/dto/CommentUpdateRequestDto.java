package com.econovation.tcono.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {
    private Long commentId;
    private Long userId;
    private Long postId;
    private String content;
    private int seq;

    @Builder
    public CommentUpdateRequestDto(Long commentId,Long userId, Long postId, String content,int seq) {
        this.commentId=commentId;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.seq=seq;
    }
}
