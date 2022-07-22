package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.MainCategory;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.post.Category;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jboss.jandex.Main;

@Data
@Getter
@NoArgsConstructor
public class PostCreateRequestDto {

    private Long userId;
    private String content;
    private String title;
    private int mainCategoryNumber;
    private String categorySplitByComma;//해시태그

    @Builder
    public PostCreateRequestDto(Long userId, String content, String title, int mainCategoryNumber, String categorySplitByComma) {
        this.userId=userId;
        this.content=content;
        this.title=title;
        this.mainCategoryNumber=mainCategoryNumber;
        this.categorySplitByComma=categorySplitByComma;//request할 때 ,로 구분됨
    }

    public Post toPostEntity() {
        return Post.builder()
                .userId(userId)
                .content(content)
                .title(title)
                .mainCategory(MainCategory.getMainCategory(mainCategoryNumber))
                .build();
    }

    public Category toCategoryEntity(Post post, String categoryName) {
        return Category.builder()
                .categoryName(categoryName)
                .post(post)
                .build();
    }
}
