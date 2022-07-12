package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.post.MainCategory;
import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.post.Category;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PostCreateRequestDto {

    private String email;
    private String content;
    private String title;
    private MainCategory mainCategory;
    private String category;

    @Builder
    public PostCreateRequestDto(String email, String content, String title, MainCategory mainCategory, String category) {
        this.email=email;
        this.content = content;
        this.title = title;
        this.mainCategory = mainCategory;
        this.category = category;
    }

    public Post toPostEntity(User user) {
        return Post.builder()
                .user(user)
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
