package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.Category;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PostUpdateRequestDto {
    private Long postId;
    private String content;
    private String title;

//    private Long mainCategoryNumber;

    private String categorySplitByComma;

    public Post toPostEntity() {
        return Post.builder()
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
