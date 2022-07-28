package com.econovation.tcono.domain.comment;

import com.econovation.tcono.domain.BaseTimeEntity;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@Table(name="comment")
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseTimeEntity {
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
    @ColumnDefault("0")
    private int parent;// 부모댓글의 Id

    @ColumnDefault("0")
    private int seq;//부모댓글내 순서
    @ColumnDefault("false")
    private Boolean isRemoved;//제거 유무

    @Builder
    public Comment(Long userId, Post post, String content, int parent,int seq) {
        this.userId = userId;
        this.post = post;
        this.content = content;
        this.seq=seq;
        this.parent=parent;
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
