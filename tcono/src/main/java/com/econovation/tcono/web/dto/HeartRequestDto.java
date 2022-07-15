package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.heart.Heart;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class HeartRequestDto {
    private Long postId;
    private Long userId;

    @Builder
    public HeartRequestDto(Long postId,Long userId) {
        this.postId=postId;
        this.userId=userId;
    }

    public Heart toEntity(Post post) {
        return Heart.builder()
                .post(post)
                .build();
    }
}
