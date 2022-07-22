package com.econovation.tcono.web.dto;

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
    public PostResponseDto(Long postId, String userName, String content, String title, int mainCategoryNumber, String categoryList, String createdDate, int hearts, int views) {
        this.postId = postId;
        this.userName = userName;
        this.content = content;
        this.title = title;
        this.mainCategoryNumber = mainCategoryNumber;
        this.categoryList=categoryList;
        this.createdDate = createdDate;
        this.hearts = hearts;
        this.views = views;

    }
}