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

    private User user;
    private String content;
    private String title;
    private MainCategory mainCategory;
    private String category;

    @Builder
    public PostCreateRequestDto(User user, String content, String title, MainCategory mainCategory, String category) {
        this.user = user;
        this.content = content;
        this.title = title;
        this.mainCategory = mainCategory;
        this.category = category;
    }

    public Post toPostEntity() {
        return Post.builder()
                .user(user)
                .content(content)
                .title(title)
                .mainCategory(mainCategory)
                .build();
    }
    public Category toCategoryEntity(Post post) {
        return Category.builder()
                .categoryName(category)
                .post(post)
                .build();
    }

}
