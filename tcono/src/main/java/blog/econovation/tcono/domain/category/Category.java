package blog.econovation.tcono.domain.category;

import blog.econovation.tcono.domain.post.Post;
import lombok.*;


import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categoryName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    public static Category create(String categoryName, Post post){
        Category category=Category.builder()
                .categoryName(categoryName)
                .post(post)
                .build();

        return category;
    }

}
