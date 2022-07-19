package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import com.econovation.tcono.domain.post.MainCategory;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jboss.jandex.Main;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class PostCreateResponseDto {
    private Long userId;
    private String content;
    private String title;
    private MainCategory mainCategory;//대분류
    private String categorySplitByComma;//해시태그
    private String createdDate;


    public PostCreateResponseDto(Post post, List<Category> categoryListByPost) {
        this.userId = post.getUserId();
        this.content = post.getContent();
        this.title = post.getCreatedDate();
        this.mainCategory = post.getMainCategory();
        this.categorySplitByComma = StringUtils.join(categoryListByPost,",");
        this.createdDate = post.getCreatedDate();
    }
}


