package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.MainCategory;
import com.econovation.tcono.domain.post.Post;
import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PostByIdResponseDto {

    private Long id;
    private Long userId;
    private String content;
    private String title;
    private Boolean official; //인기글
    private int views; //조회수
    private int hearts; //좋아요
    private MainCategory mainCategory; //대분류

    @Builder
    public PostByIdResponseDto(Post post){
        this.id=post.getId();
        this.userId= post.getUserId();
        this.title=post.getTitle();
        this.official=post.getOfficial();
        this.views=post.getViews();
        this.hearts=post.getHearts();
        this.mainCategory=post.getMainCategory();
    }
}
