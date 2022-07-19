package com.econovation.tcono.domain.post;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";

    private final PostRepository postRepository;

    /**
     * @param : mainCategory
     * @return List<Post>
     * 각 대분류에 맞는 Post 보내기
     * 페이징 처리(10개)
     */

    @Transactional
    public List<Post> findAllPosts(MainCategory mainCategory) {
        List<Post> post = postRepository.findAllByMainCategory(MainCategory.getMainCategory(mainCategory));
        return post;
    }

    /**
     * @param : postId
     * @return Post
     * 댓글 같이 보내기
     */

    public Post findPostByPostId(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        increaseViews(post);
        return post;
    }

    @Transactional
    public int increaseViews(Post post) {
        postRepository.updateViews(post.getId());
        return post.getViews();
    }
}