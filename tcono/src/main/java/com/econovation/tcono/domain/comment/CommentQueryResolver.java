//package com.econovation.tcono.domain.comment;
<<<<<<< HEAD
//
//import com.econovation.tcono.domain.post.Post;
//import com.econovation.tcono.domain.post.PostRepository;
//import com.econovation.tcono.domain.user.UserRepository;
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//
//import javax.transaction.Transactional;
//import java.util.List;
=======

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.PostRepository;
import com.econovation.tcono.domain.user.UserRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.econovation.tcono.web.dto.CommentCreateResponseDto;

import javax.transaction.Transactional;
import java.util.List;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
//
//public class CommentQueryResolver implements GraphQLQueryResolver {
//    private static final String NOT_FOUND_USER_MESSAGE ="해당 유저는 존재하지 않습니다";
//    private static final String NOT_FOUND_POST_MESSAGE ="해당 페이지는 존재하지 않습니다.";
//    private CommentRepository commentRepository;
//    private UserRepository userRepository;
//    private PostRepository postRepository;
//
//    @Transactional
<<<<<<< HEAD
//    public List(int postId) {
=======
//    public CommentCreateResponseDto List(int postId) {
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
//        Post post = postRepository.findById()
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
//
//        //TODO
//        // optional로 받아야 할지 고민해보기
//        List<Comment> commentList = commentRepository.findByPostId(postId);
//        return CommentCreateResponseDto;
//    }
//
<<<<<<< HEAD
//
=======

>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
//}
