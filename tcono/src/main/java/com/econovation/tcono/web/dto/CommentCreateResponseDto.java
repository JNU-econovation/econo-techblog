package com.econovation.tcono.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentCreateResponseDto {
    private Long userId;
    private Long postId;
    private String content;
    private int depth;
    private int group;

<<<<<<< HEAD
    private String createdDate;

=======
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
    @Builder
    public void CommentCreateRequestDto(Long userId, Long postId, String content, int depth, int group){
        this.userId=userId;
        this.postId=postId;
        this.content=content;
        this.depth=depth;
        this.group=group;
    }

}
