package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class PostUpdateResponseDto {
    private Long postId;
    private Long userId;
    private String content;
    private String title;

    private int mainCategoryNumber;
    private String categorySplitByComma;
    private String createdDate;
    private int views;
    private int hearts;


    @Builder
    public PostUpdateResponseDto(Post post, List<String>categoryName) {
        this.postId=post.getId();
        this.userId=post.getUserId();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.mainCategoryNumber=post.getMainCategory().getMainCategoryNumber();
        this.categorySplitByComma=String.join(",", categoryName);
        this.createdDate= post.getCreatedDate();
        this.views=post.getViews();
        this.hearts = post.getHearts();
    }
}
