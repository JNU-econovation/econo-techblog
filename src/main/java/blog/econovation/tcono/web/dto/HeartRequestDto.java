package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.heart.Heart;
import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class HeartRequestDto {
    private String userEmail;
    private Post post;
    private User user;

    @Builder
    public HeartRequestDto(String userEmail, Post post, User user ) {
        this.userEmail=userEmail;
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
