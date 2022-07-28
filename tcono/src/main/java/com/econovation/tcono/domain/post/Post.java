package com.econovation.tcono.domain.post;

import com.econovation.tcono.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    //post 작성자 이름
    @Column(updatable = false)
    private Long userId;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String title;
    @Column(insertable = false, updatable = false,nullable = true)
    @ColumnDefault("false")
    private Boolean official; //인기글

    @Column(insertable = false)
    @ColumnDefault("0")
    private int views; //조회수
    @Column(insertable = false)
    @ColumnDefault("0")
    private int hearts; //좋아요

//    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
//    private List<Heart> Heart = new ArrayList<>();

//    @OneToMany(mappedBy = "post", ,cascade=CascadeType.All)
//    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Category> categoryList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MainCategory mainCategory; //대분류

    @Builder
    public Post(Long userId, String content, String title, MainCategory mainCategory) {
        this.userId = userId;
        this.content = content;
        this.title = title;
        this.mainCategory = mainCategory;
    }
    public void decreaseHearts() {
        this.hearts -= 1;
    }

    public void increaseHearts() {
        this.hearts += 1;
    }


    public void updatePost(String content, String title,List<Category>categoryList) {
        this.content = content;
        this.title = title;
        this.categoryList=categoryList;
    }

    public void updateOfficial() {
        this.official = true;
    }

}
