package blog.econovation.tcono.domain.post;

import blog.econovation.tcono.domain.BaseTimeEntity;
import jdk.jfr.Category;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long Id;

    private String content;

    private String title;

    private Boolean official;

    @OneToMany(mappedBy = "post", cascade = All, orphanRemoval = true)
    private List<Category> categoryList = new ArrayList<>();

    //게시글 삭제하면 해당 게시글의 댓글 모두 삭제
//    @OneToMany(mappedBy = "post", cascade = All, orphanRemoval = true)
//    private List<Comment> commentList = new ArrayList<>();

    public void addCategory(Category category) {
        categoryList.add(category);
    }

//    public void addComment(Comment comment) {
//        commentList.add(comment);
}

    //내용 수정
    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Post create(Long postId, String title, String content) {
        return new Post(postId, title, content, false);
    }
}


