<<<<<<< HEAD
//package com.econovation.tcono.web.dto;
//
//import com.econovation.tcono.domain.comment.Comment;
//import com.econovation.tcono.domain.post.Post;
//import com.econovation.tcono.domain.user.User;
//import lombok.Builder;
//import lombok.Data;
//import lombok.Getter;
//
//@Data
//@Getter
//public class CommentCreateRequestDto {
//    private Long userId;
//    private Long postId;
//    private String content;
//    private int depth;
//    private int group;
//
//    @Builder
//    public CommentCreateRequestDto(Long userId, Long postId, String content, int depth, int group) {
//        this.userId = userId;
//        this.postId = postId;
//        this.content = content;
//        this.depth = depth;
//        this.group = group;
//    }
//
//    public Comment toEntity(Post post, User user) {
//        return Comment.builder()
//                .user(user)
//                .post(post)
//                .content(content)
//                .depth(depth)
//                .group(group)
//                .build();
//    }
//
//}
=======
package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.comment.Comment;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CommentCreateRequestDto {
    private Long userId;
    private Long postId;
    private String content;
    private int depth;
    private int group;

    @Builder
    public CommentCreateRequestDto(Long userId, Long postId, String content, int depth, int group) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.depth = depth;
        this.group = group;
    }

    public Comment toEntity(Post post, User user) {
        return Comment.builder()
                .user(user)
                .post(post)
                .content(content)
                .depth(depth)
                .group(group)
                .build();
    }

}
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
