package com.econovation.tcono.domain.heart;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.PostRepository;
//import com.econovation.tcono.domain.user.User;
//import com.econovation.tcono.domain.user.UserRepository;
import com.econovation.tcono.domain.user.UserRepository;
import com.econovation.tcono.web.dto.HeartRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class HeartMutationResolver implements GraphQLMutationResolver {
    private static final String NOT_FOUND_USER_MESSAGE = "존재하지 않은 회원입니다.";
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 존재하지 않습니다.";

    private Post post;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private HeartRepository heartRepository;



    @Transactional
    public int updateHeartState(HeartRequestDto heartRequestDto) {
        Post post=postRepository.findById(heartRequestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        //좋아요 삭제
        if (heartRequestDto.getIsHeart()) {
            heartRepository.delete(heartRequestDto.toEntity(post));
            return post.decreaseHearts();
        } else { // 좋아요 추가
            heartRepository.save(heartRequestDto.toEntity(post));
            return post.increaseHearts();
        }
    }
}