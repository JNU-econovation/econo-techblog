package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.heart.Heart;
import com.econovation.tcono.domain.post.Post;
import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeartRequestDto {
    private Long postId;
    private Long userId;
    private Boolean isHeart;

    public Heart toEntity(Post post) {
        return Heart.builder()
                .post(post)
                .userId(userId)
                .isHeart(isHeart)
                .build();
    }
}
