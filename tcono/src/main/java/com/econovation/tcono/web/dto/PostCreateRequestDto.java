package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.MainCategory;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.post.Category;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PostCreateRequestDto {

    private Long userId;
    private String content;
    private String title;
    private MainCategory mainCategory;
    private String category;

    @Builder
    public PostCreateRequestDto(Long userId, String content, String title, MainCategory mainCategory, String category) {
        this.userId=userId;
        this.content = content;
        this.title = title;
        this.mainCategory = mainCategory;
        this.category = category;
    }

    public Post toPostEntity(User user) {
        return Post.builder()
                .userId(userId)
                .content(content)
                .title(title)
                .mainCategory(mainCategory)
                .build();
    }

    public Category toCategoryEntity(Post post, String categoryName) {
        return Category.builder()
                .categoryName(categoryName)
                .post(post)
                .build();
    }
}
