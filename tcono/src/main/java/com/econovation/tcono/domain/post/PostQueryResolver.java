package com.econovation.tcono.domain.post;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";

    private PostRepository postRepository;
    @Autowired
    public PostQueryResolver(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * @param : mainCategory
     * @return List<Post>
     * 각 대분류에 맞는 Post 보내기
     * 페이징 처리(10개)
     */

    public List<Post> findAllPosts(MainCategory mainCategory) {
        List<Post> post = postRepository.findByMainCategory(MainCategory.getMainCategory(mainCategory));
        return post;
    }

    /**
     * @param : postId
     * @return Post
     * 댓글 같이 보내기
     */

    public Post getFindPostByPosyId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        post.increaseViews();
        return post;
    }
}