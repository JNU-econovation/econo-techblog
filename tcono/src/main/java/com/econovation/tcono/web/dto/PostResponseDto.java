package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;

import java.util.List;

public class PostResponseDto {

    private Long postId;
    private String userName;
    private String content;
    private String title;
    private int mainCategoryNumber;//대분류
    private String categoryList;
    private String createdDate;
    private int hearts;
    private int views;

    @Builder
    public PostResponseDto(Post post, User user, String categoryList) {
        this.postId = post.getId();
        this.userName = user.getUserName();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.mainCategoryNumber = post.getMainCategory().getMainCategoryNumber();
        this.categoryList=categoryList;
        this.createdDate = post.getCreatedDate();
        this.hearts = post.getHearts();
        this.views = post.getViews();

    }
}