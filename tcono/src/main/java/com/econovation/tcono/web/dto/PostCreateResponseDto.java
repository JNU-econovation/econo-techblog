package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class PostCreateResponseDto {
<<<<<<< HEAD
    private Long userId;
=======
    private User user;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
    private String content;
    private String title;
    private String categoryListByPost;
    private int views;
    private int likes;
    private String createdDate;


    public PostCreateResponseDto(Post post, List<Category> categoryListByPost) {
<<<<<<< HEAD
        this.userId=post.getUserId();
=======
        this.user=post.getUser();
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
        this.content = post.getContent();
        this.title = post.getCreatedDate();
        this.categoryListByPost=categoryListByPost.toString();
        this.createdDate= post.getCreatedDate();
    }
}


