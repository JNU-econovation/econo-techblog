package com.econovation.tcono.web.dto;

<<<<<<< HEAD
import com.econovation.tcono.domain.heart.Heart;
=======
//import com.econovation.tcono.domain.heart.Heart;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class HeartRequestDto {
<<<<<<< HEAD
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
=======
    private Post post;
    private User user;

    @Builder
    public HeartRequestDto(Post post, User user) {
        this.post=post;
        this.user=user;
    }
//
//    public Heart toEntity() {
//        return Heart.builder()
//                .post(post)
//                .user(user)
//                .build();
//    }
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
}
