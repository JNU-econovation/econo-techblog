package blog.econovation.tcono.domain.post;

import blog.econovation.tcono.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long Id;
    private String categoryName;
    @ManyToOne(optional = false)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Builder
    public Category(String categoryName, Post post) {
        this.categoryName = categoryName;
        this.post = post;
    }
}
