package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
public class PostUpdateResponseDto {
    private User user;
    private String content;
    private String title;
    private String category; //태그
    private int views;
    private int likes;
    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    @Builder
    public PostUpdateResponseDto(Post post, String category) {
        this.user = post.getUser();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.category = category;
        this.views=post.getViews();
        this.likes = post.getLike();
        this.createdDate= post.getCreatedDate();
        this.modifiedDate=post.getModifiedDate();
    }
}