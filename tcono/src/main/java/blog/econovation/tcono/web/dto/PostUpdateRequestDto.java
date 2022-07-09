package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.domain.post.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostUpdateRequestDto {
    private String content;
    private String title;
    private String category;

    public Post toPostEntity() {
        return Post.builder()
                .content(content)
                .title(title)
                .build();
    }

    public Category toCategoryEntity(Post post) {
        return Category.builder()
                .categoryName(category)
                .post(post)
                .build();
    }
}
