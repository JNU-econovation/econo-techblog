//package com.econovation.tcono.domain.comment;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.PostRepository;
import com.econovation.tcono.domain.user.UserRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.econovation.tcono.web.dto.CommentCreateResponseDto;

import javax.transaction.Transactional;
import java.util.List;
//
//public class CommentQueryResolver implements GraphQLQueryResolver {
//    private static final String NOT_FOUND_USER_MESSAGE ="해당 유저는 존재하지 않습니다";
//    private static final String NOT_FOUND_POST_MESSAGE ="해당 페이지는 존재하지 않습니다.";
//    private CommentRepository commentRepository;
//    private UserRepository userRepository;
//    private PostRepository postRepository;
//
//    @Transactional
//    public CommentCreateResponseDto List(int postId) {
//        Post post = postRepository.findById()
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
//
//        //TODO
//        // optional로 받아야 할지 고민해보기
//        List<Comment> commentList = commentRepository.findByPostId(postId);
//        return CommentCreateResponseDto;
//    }
//

//}
