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

<<<<<<< HEAD
    private Long userId;
=======
    private User user;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
    private String content;
    private String title;
    private MainCategory mainCategory;
    private String category;

    @Builder
<<<<<<< HEAD
    public PostCreateRequestDto(Long userId, String content, String title, MainCategory mainCategory, String category) {
        this.userId=userId;
=======
    public PostCreateRequestDto(User user, String content, String title, MainCategory mainCategory, String category) {
        this.user=user;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
        this.content = content;
        this.title = title;
        this.mainCategory = mainCategory;
        this.category = category;
    }

    public Post toPostEntity(User user) {
        return Post.builder()
<<<<<<< HEAD
                .userId(userId)
=======
                .user(user)
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
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
