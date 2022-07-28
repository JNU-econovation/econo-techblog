package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.comment.Comment;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class CommentCreateRequestDto {
    private Long userId; //유저정보
    private Long postId; // 글정보
    private String content;//내용


    @Builder
    public CommentCreateRequestDto(Long userId, Long postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }

    public Comment toEntity(Post post,int parent) {
        return Comment.builder()
                .userId(userId)
                .post(post)
                .content(content)
                .parent(parent)
                .build();
    }
}
