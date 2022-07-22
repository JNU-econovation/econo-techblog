package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class PostUpdateResponseDto {
    private Long userId;
    private String content;
    private String title;
    private String categorySplitByComma;
    private int views;
    private int hearts;
    private String createdDate;

    @Builder
    public PostUpdateResponseDto(Post post, List<Category>categoryList) {
        this.userId=post.getUserId();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.categorySplitByComma=categoryList.toString();
        this.views=post.getViews();
        this.hearts = post.getHearts();
        this.createdDate= post.getCreatedDate();
    }
}