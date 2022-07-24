package com.econovation.tcono.domain.heart;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.PostRepository;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor

public class HeartQueryResolver implements GraphQLQueryResolver {

    private static final String NOT_FOUND_USER_MESSAGE = "해당 유저가 존재하지 않습니다.";
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 존재하지 않습니다.";
    private Post post;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private HeartRepository heartRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Boolean isHeart(Long postId, Long userId) {
        User isUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        Optional<Heart> isHeart = heartRepository.findByUserIdAndPost(userId, post);

        if (isHeart.isPresent()) {
            return true;
        }
        return false;
    }
}
