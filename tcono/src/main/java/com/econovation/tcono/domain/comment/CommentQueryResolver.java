package com.econovation.tcono.domain.comment;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.PostRepository;
import com.econovation.tcono.domain.user.UserRepository;
import com.econovation.tcono.web.dto.CommentResponseDto;
import com.econovation.tcono.web.dto.PostListResponseDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CommentQueryResolver implements GraphQLQueryResolver {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    private static final String NOT_FOUND_POST_MESSAGE = "해당 글이 존재하지 않습니다.";

    public List<CommentResponseDto> findCommentByPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        List<Comment> comment = commentRepository.findCommentsByPost(post);
        List<CommentResponseDto> collect = comment.stream().map(CommentResponseDto::new)
                .sorted(Comparator.comparing(CommentResponseDto::getParent))
                .collect(Collectors.toList());
        return collect;
    }
}
