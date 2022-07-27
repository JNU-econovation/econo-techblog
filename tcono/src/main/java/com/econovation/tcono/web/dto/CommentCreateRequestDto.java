package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.comment.Comment;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentCreateRequestDto {
    private Long userId; //유저정보
    private Long postId; // 글정보
    private String content;
    private int depth; //댓글? 대댓글?
    private int group;//부모댓글

    @Builder
    public CommentCreateRequestDto(Long userId, Long postId, String content, int depth, int group) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.depth = depth;
        this.group = group;
    }

    public Comment toEntity(Post post) {
        return Comment.builder()
                .userId(userId)
                .post(post)
                .content(content)
                .depth(depth)
                .group(group)
                .build();
    }



}
