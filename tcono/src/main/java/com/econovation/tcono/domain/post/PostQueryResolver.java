package com.econovation.tcono.domain.post;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver{
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";
    @Autowired
    private final PostRepository postRepository;

    /**
     * @param : mainCategory
     * @return List<Post>
     * 각 대분류에 맞는 Post 보내기
     * 페이징 처리(10개)
     */
    @Transactional
    public List<Post> findAllPosts(MainCategory mainCategory, int page) {
        Pageable pageable = PageRequest.of(page, 5);
        List<Post> post = postRepository.findAllByMainCategory(MainCategory.getMainCategory(mainCategory), pageable);
        return post;
    }

    /**
     * @param : postId
     * @return Post
     * 댓글 같이 보내기
     */
    @Transactional
    public Post findPostByPostId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        increaseViews(post);
        return post;
    }


    @Transactional
    public int increaseViews(Post post) {
        postRepository.updateViews(post.getId());
        return post.getViews();
    }
        
    /**
     * @param : string Keyword
     * @return List<Post>
     * title로 like 검색 기능
     */
    @Transactional
    public List<Post> search(String keyword, int page){
        Pageable pageable = PageRequest.of(page, 5);
        List<Post> postList = postRepository.findByTitleContaining(keyword,pageable);
        return postList;
    }
}