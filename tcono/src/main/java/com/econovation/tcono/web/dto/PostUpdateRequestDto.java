package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.MainCategory;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.Category;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;


@Data
@NoArgsConstructor
public class PostUpdateRequestDto {
    private Long postId;
    private String content;
    private String title;
    private int mainCategoryNumber;

    private String categorySplitByComma;

    public Post toPostEntity() {
        return Post.builder()
                .mainCategory(MainCategory.getMainCategory(mainCategoryNumber))
                .content(content)
                .title(title)
                .build();
    }

   //categoryName : category 1개
    public Category toCategoryEntity(Post post, String categoryName) {
        return Category.builder()
                .categoryName(categoryName)
                .post(post)
                .build();
    }
}
