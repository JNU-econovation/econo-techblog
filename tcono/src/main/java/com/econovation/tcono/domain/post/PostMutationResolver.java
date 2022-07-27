package com.econovation.tcono.domain.post;

import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.econovation.tcono.web.dto.*;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostMutationResolver implements GraphQLMutationResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 존재하지 않습니다.";
    private static final String NOT_FOUND_USER_MESSAGE = "해당 유저가 존재하지 않습니다.";
    private static final String NOT_FOUND_MAINCATEGORY_MESSAGE = "해당 메인카테고리가 존재하지 않습니다.";
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Post create 구현
     *
     * @param postCreateRequestDto
     * @return Post
     */
    @Transactional
    public PostCreateResponseDto createPost(PostCreateRequestDto postCreateRequestDto) {
        User user = userRepository.findById(postCreateRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));

        if(postCreateRequestDto.getMainCategoryNumber()==0){
            throw new IllegalArgumentException(NOT_FOUND_MAINCATEGORY_MESSAGE);
        }
        Post post = postRepository.save(postCreateRequestDto.toPostEntity());

        //,로 구분된 category를 List형태로 바꿈
        List<String> categories = categoryListToEntity(postCreateRequestDto.getCategorySplitByComma());

        //category 저장
        categories.stream().forEach(x -> categoryRepository.save(postCreateRequestDto.toCategoryEntity(post, x)));

        List<String> categoryListByPost = categoryRepository.findCategoriesByPost(post);
        return new PostCreateResponseDto(post, categoryListByPost);
    }   

    /**
     * Post update 구
     *
     * @param postUpdateRequestDto
     * @return PostResponseDto
     */
    @Transactional
    public PostUpdateResponseDto updatePost(PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(postUpdateRequestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        List<Category> categories = categoryListToEntity(postUpdateRequestDto.getCategorySplitByComma())
                .stream().map(x->postUpdateRequestDto.toCategoryEntity(post,x))
                .collect(Collectors.toList());

        List<String>categoryName=categories.stream().map(Category::getCategoryName)
                        .collect(Collectors.toList());

        post.updatePost(postUpdateRequestDto.getContent(), postUpdateRequestDto.getTitle(), categories);

        return new PostUpdateResponseDto(post, categoryName);
    }

    /**
     * String 을 List로 변환하기
     *
     * @param category
     * @return Stream<String>
     */
    @Transactional
    public List<String> categoryListToEntity(String category) {
        List<String> categoryList = Arrays.asList(category.split(","));
        return categoryList;
    }

    /**
     * 해당 Post 제거
     * @param postId
     * @return boolean
     */
    @Transactional
    public boolean deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        postRepository.delete(post);
        return true;
    }

    /**
     * 좋아요 10 이상, views가 10 이상인 글 official로 보내주고, 등록함
     *
     * @return boolean
     */

    //TODO : official 조건 추가
    @Transactional
    public List<PostListResponseDto> findOfficial(){
        List<Post> officialPost = postRepository.findAll().stream()
                .filter(x -> x.getViews() > 2)
                .sorted(Comparator.comparing(Post::getModifiedDate))
                .limit(3)
                .collect(Collectors.toList());

        officialPost.forEach(Post::updateOfficial);
        return officialPost.stream().map(x->new PostListResponseDto(x,userRepository.findById(x.getUserId()),x.getCategoryList()))
                .collect(Collectors.toList());


    }
}
