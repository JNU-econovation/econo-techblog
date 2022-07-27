package com.econovation.tcono.domain.heart;

import com.econovation.tcono.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HEART_ID")
    private Long id;

//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "USER_ID")
//    private User user;
    @Column(nullable = false)
    private Long userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POST_ID")
    private Post post;

    //좋아요 여부
    private Boolean isHeart;


    @Builder
    public Heart(Long userId, Post post,Boolean isHeart) {
        this.userId=userId;
        this.post = post;
        this.isHeart=isHeart;
    }
}
