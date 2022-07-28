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
    private Long commentId;

    private Long userId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POST_ID")
    private Post post;
    @Lob
    @Column(nullable = false)
    private String content;

    private int depth; // 일반 댓글 = 0, 대댓글 = 1

    private int group;// 부모댓글의 Id

    private Boolean isRemoved = false;//제거 유무

    @Builder
    public Comment(Long userId, Post post, String content, int depth, int group) {
        this.userId = userId;
        this.post = post;
        this.content = content;
        this.depth = depth;
        this.group = group;
    }

    //==수정==/
    public void updateComment(String content) {
        this.content = content;
    }

    //==삭제==/
    public void remove() {
        this.isRemoved = true;
    }
}
