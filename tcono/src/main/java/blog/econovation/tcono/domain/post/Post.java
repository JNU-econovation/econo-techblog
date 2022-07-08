package blog.econovation.tcono.domain.post;

import blog.econovation.tcono.domain.BaseTimeEntity;
import blog.econovation.tcono.domain.user.User;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTimeEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    private String content;
    private String title;
    private Boolean official; //인기글
    private int views; //조회수
    private int like; //좋아요 수

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Category> categoryList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MainCategory mainCategory; //대분류

    @Builder
    public Post(User user, String content, String title, MainCategory mainCategory) {
        this.user = user;
        this.content = content;
        this.title = title;
        this.mainCategory = mainCategory;
    }

    public void addViews() {
        this.views += 1;
    }

    public void deleteLike() {
        this.like -= 1;
    }

    public void addLike() {
        this.like += 1;
    }


    public void updatePost(String content, String title) {
        this.content = content;
        this.title = title;
    }
}
