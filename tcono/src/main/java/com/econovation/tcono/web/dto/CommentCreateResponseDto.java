package com.econovation.tcono.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentCreateResponseDto {
    private Long commentId;//comment Id 정보
    private Long userId;
    private Long postId;
    private String content;
    private int depth;
    private int group;

    private String createdDate;

    @Builder
    public void CommentCreateRequestDto(Long commentId,Long userId, Long postId, String content, int depth, int group){
        this.commentId=commentId;
        this.userId=userId;
        this.postId=postId;
        this.content=content;
        this.depth=depth;
        this.group=group;
    }

}
