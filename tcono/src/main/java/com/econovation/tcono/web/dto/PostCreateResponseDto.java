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
    private Long userId;
    private String content;
    private String title;
    private String categoryListByPost;
    private int views;
    private int likes;
    private String createdDate;


    public PostCreateResponseDto(Post post, List<Category> categoryListByPost) {
        this.userId=post.getUserId();
        this.content = post.getContent();
        this.title = post.getCreatedDate();
        this.categoryListByPost=categoryListByPost.toString();
        this.createdDate= post.getCreatedDate();
    }
}


