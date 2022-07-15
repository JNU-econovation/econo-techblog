package com.econovation.tcono.domain.post;
<<<<<<< HEAD
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e

import javax.transaction.Transactional;
import java.util.List;

<<<<<<< HEAD
@Service
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";

    private PostRepository postRepository;
    @Autowired
    public PostQueryResolver(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
=======
@Component
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";
    private final PostRepository postRepository;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e

    /**
     * @param : mainCategory
     * @return List<Post>
     * 각 대분류에 맞는 Post 보내기
     * 페이징 처리(10개)
     */

<<<<<<< HEAD
=======
    @Transactional
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
    public List<Post> findAllPosts(MainCategory mainCategory) {
        List<Post> post = postRepository.findByMainCategory(MainCategory.getMainCategory(mainCategory));
        return post;
    }

    /**
     * @param : postId
     * @return Post
     * 댓글 같이 보내기
     */

<<<<<<< HEAD
    public Post getFindPostByPosyId(Long postId) {
=======
    @Transactional
    public Post findPostByPosyId(Long postId) {
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        post.increaseViews();
        return post;
    }
}