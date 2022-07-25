package com.econovation.tcono.domain.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import com.econovation.tcono.web.dto.PostListResponseDto;
import com.econovation.tcono.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<PostListResponseDto> findAllPosts(int mainCategoryNumber, int page) {
        Pageable pageable = PageRequest.of(page, 5);

        List<Post> allPostsByMainCategory = postRepository.findAllByMainCategory(MainCategory.getMainCategory(mainCategoryNumber),pageable);

        return allPostsByMainCategory.stream().map(x->new PostListResponseDto(x,userRepository.findById(x.getUserId()),x.getCategoryList()))
                .collect(Collectors.toList());
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

        User user=userRepository.findById(post.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        List<String>categoryNameList=post.getCategoryList().stream().map(Category::getCategoryName).collect(Collectors.toList());
        String categoryName=String.join(",",categoryNameList);

        increaseViews(post); //조회수 증가
        return new PostResponseDto(post,user,categoryName);
    }
    //user.getUserName()


    @Transactional
    public int increaseViews(Post post) {
        postRepository.updateViews(post.getId());
        return post.getViews();
    }

    @Transactional
    public List<String> categoryListToEntity(String category) {
        List<String> categoryList = Arrays.asList(category.split(","));
        return categoryList;
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

    @Transactional
    public Long postCounts(){
        return postRepository.countPosts();
    }
}