package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.comment.Comment;
import com.econovation.tcono.domain.post.Post;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Getter
@NoArgsConstructor
public class ReplyCreateRequestDto {

    private Long userId;
    private Long postId;
    private String content;
    private int parent;// 그룹핑 넘버

    @Builder
    public ReplyCreateRequestDto(Long userId, Long postId, String content,int parent) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.parent=parent;
    }

    public Comment toEntity(Post post) {
        return Comment.builder()
                .userId(userId)
                .post(post)
                .content(content)
                .parent(parent)
                .build();
    }
}
