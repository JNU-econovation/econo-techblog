package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
public class PostCreateResponseDto {
    private static final int INITIAL_VIEWS=0;
    private static final int INITIAL_LIKES=0;

    private User user;
    private String content;
    private String title;
    private String categoryName; //태그
    private int views;
    private int likes;
    private String createdDate;

    @Builder
    public PostCreateResponseDto(Post post, String categoryName) {
        this.user = post.getUser();
        this.content = post.getContent();
        this.title = post.getCreatedDate();
        this.categoryName = categoryName;
        this.views=INITIAL_VIEWS;
        this.likes = INITIAL_LIKES;
        this.createdDate= post.getCreatedDate();
    }
}