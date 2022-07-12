package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.post.Category;
import blog.econovation.tcono.domain.post.Post;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Getter
public class PostCreateResponseDto {
    private String userName;
    private String content;
    private String title;
    private String categoryListByPost;
    private int views;
    private int likes;
    private String createdDate;


    public PostCreateResponseDto(Post post, List<Category> categoryListByPost) {
        this.userName =post.getUser().getUserName();
        this.content = post.getContent();
        this.title = post.getCreatedDate();
        this.categoryListByPost=categoryListByPost.toString();
        this.createdDate= post.getCreatedDate();
    }
}


