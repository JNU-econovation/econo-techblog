package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import com.econovation.tcono.domain.post.Post;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class PostCreateResponseDto {
    private Long postId;
    private Long userId;
    private String content;
    private String title;
    private int mainCategoryNumber;//대분류
    private String categorySplitByComma;
    private String createdDate;
    private int hearts;
    private int views;


    public PostCreateResponseDto(Post post, List<String> categoryList) {
        this.postId=post.getId();
        this.userId = post.getUserId();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.mainCategoryNumber = post.getMainCategory().getMainCategoryNumber(); //해당 post의 mainCategoryNumber을 보내줘야 함
        this.categorySplitByComma= String.join(",", categoryList);
        this.createdDate = post.getCreatedDate();
        this.hearts=post.getHearts();
        this.views=post.getViews();
    }
}


