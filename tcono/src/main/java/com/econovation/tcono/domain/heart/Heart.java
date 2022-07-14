//package com.econovation.tcono.domain.heart;
//
//import com.econovation.tcono.domain.post.Post;
//import com.econovation.tcono.domain.user.User;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Heart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "HEART_ID")
//    private Long Id;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "USER_ID")
//    private User user;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "POST_ID")
//    private Post post;
//
//    @Builder
//    public Heart(User user, Post post) {
//        this.user = user;
//        this.post = post;
//    }
//}
