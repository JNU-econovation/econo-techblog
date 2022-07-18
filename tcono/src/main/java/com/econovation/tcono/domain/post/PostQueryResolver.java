package com.econovation.tcono.domain.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
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
    public List<Post> findAllPosts(MainCategory mainCategory,Pageable pageable) {
        List<Post> post = postRepository.findAllByMainCategory(MainCategory.getMainCategory(mainCategory), pageable);
        return post;
    }

    /**
     * @param : postId
     * @return Post
     * 댓글 같이 보내기
     */

    @Transactional
    public Post findPostByPosyId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        post.increaseViews();
        return post;
    }
    /**
     * @param : string Keyword
     * @return List<Post>
     * title로 like 검색 기능
     */
    @Transactional
    public List<Post> search(String keyword, Pageable pageable){
        List<Post> postList = postRepository.findByTitleContaining(keyword,pageable);
        return postList;
    }
}