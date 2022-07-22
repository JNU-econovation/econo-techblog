package com.econovation.tcono.domain.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import com.econovation.tcono.web.dto.PostResponseDto;
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
public class PostQueryResolver implements GraphQLQueryResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";
    private static final String NOT_FOUND_USER_MESSAGE="해당 유저가 없습니다";
    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * @param : mainCategory
     * @return List<Post>
     * 각 대분류에 맞는 Post 보내기
     * 페이징 처리(10개)
     */
    @Transactional
    public List<PostResponseDto> findAllPosts(int mainCategoryNumber, int page) {
        Pageable pageable = PageRequest.of(page, 5);
        List<Post> post = postRepository.findAllByMainCategory(MainCategory.getMainCategory(mainCategoryNumber));


        return post;
    }

    /**
     * @param : postId
     * @return Post
     * 댓글 같이 보내기
     */
    @Transactional
    public PostResponseDto findPostByPostId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

//        User user=userRepository.findById(post.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        increaseViews(post); //조회수 증가
        return new PostResponseDto(post.getId(),"수민",post.getContent(),post.getTitle(),post.getMainCategory().getMainCategoryNumber(),post.getCategoryList().toString(),post.getCreatedDate(),post.getHearts(),post.getViews());
    }
    //user.getUserName()


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
//    @Transactional
//    public List<PostResponseDto> search(String keyword, int page) {
//        Pageable pageable = PageRequest.of(page, 5);
//        List<Post> postList = postRepository.findByTitleContaining(keyword, pageable);
//        return postList;
//    }
}