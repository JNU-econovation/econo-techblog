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
    private Post post;
    private User user;

    @Builder
    public HeartRequestDto(Post post, User user) {
        this.post=post;
        this.user=user;
    }

    public Heart toEntity() {
        return Heart.builder()
                .post(post)
                .user(user)
                .build();
    }
}
