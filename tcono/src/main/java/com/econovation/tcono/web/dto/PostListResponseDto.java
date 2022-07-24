package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

public class PostDto {

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
    public PostDto(Post post, User user){
        this.postId = post.getId();
        this.userName = user.getUserName();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.mainCategoryNumber = post.getMainCategory().getMainCategoryNumber();
        this.categoryList=post.getCategoryList().stream().map(Category::getCategoryName).collect(Collectors.toList()).toString();
        this.createdDate = post.getCreatedDate();
        this.hearts = post.getHearts();
        this.views = post.getViews();

    }
}