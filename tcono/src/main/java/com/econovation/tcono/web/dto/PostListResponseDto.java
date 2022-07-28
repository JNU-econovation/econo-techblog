package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostListResponseDto {

    private Long postId;
    private String userName;
    private String content;
    private String title;
    private int mainCategoryNumber;//대분류
    private String categoryName;
    private String createdDate;

    private String modifiedDate;
    private int hearts;
    private int views;

    @Builder
    public PostListResponseDto(Post post, Optional<User> user, List<Category> categoryList) {
        this.postId = post.getId();
        this.userName = user.get().getUserName();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.mainCategoryNumber = post.getMainCategory().getMainCategoryNumber();
        this.categoryName=String.join(",",categoryList.stream().map(x->x.getCategoryName()).collect(Collectors.toList()));
        this.createdDate = post.getCreatedDate();
        this.modifiedDate=post.getModifiedDate();
        this.hearts = post.getHearts();
        this.views = post.getViews();
    }


}