package com.econovation.tcono.domain.comment;

import com.econovation.tcono.domain.BaseTimeEntity;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseTimeEntity {//자식 댓글
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;
    @Lob
    @Column(nullable = false)
    private String content;

    private int depth; // 일반 댓글 = 0, 대댓글 = 1

    private int group;// 부모댓글의 Id

    @Builder
    public Comment(User user, Post post, String content, int depth, int group) {
        this.user = user;
        this.post = post;
        this.content = content;
        this.depth=depth;
        this.group=group;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
