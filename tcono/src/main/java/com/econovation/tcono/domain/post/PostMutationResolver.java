package com.econovation.tcono.domain.post;

import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.econovation.tcono.web.dto.PostCreateRequestDto;
import com.econovation.tcono.web.dto.PostCreateResponseDto;
import com.econovation.tcono.web.dto.PostUpdateRequestDto;
import com.econovation.tcono.web.dto.PostUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class PostMutationResolver implements GraphQLMutationResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 존재하지 않습니다.";
    private static final String NOT_FOUND_USER_MESSAGE = "해당 유저가 존재하지 않습니다.";
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    /**
     * Post create 구현
     *
     * @param postCreateRequestDto
     * @return Post
     */
    @Transactional
    public PostCreateResponseDto createPost(PostCreateRequestDto postCreateRequestDto) {
        User user = userRepository.findById(postCreateRequestDto.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        Post post = postRepository.save(postCreateRequestDto.toPostEntity(user));

        //category entity 생성 후 save
        categoryListToEntity(postCreateRequestDto.getCategory())
                .forEach(x -> categoryRepository.save(postCreateRequestDto.toCategoryEntity(post, x)));

        List<Category> categoryListByPost = categoryRepository.findByPost(post);
        return new PostCreateResponseDto(post, categoryListByPost);
    }

    /**
     * Post update 구현
     *
     * @param postUpdateRequestDto
     * @return PostResponseDto
     */
    @Transactional
    public PostUpdateResponseDto updatePost(Long id, PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        post.updatePost(postUpdateRequestDto.getContent(), postUpdateRequestDto.getTitle());
        categoryListToEntity(postUpdateRequestDto.getCategory())
                .forEach(x -> categoryRepository.save(postUpdateRequestDto.toCategoryEntity(post, x)));

        List<Category> categoryListByPost = categoryRepository.findByPost(post);
        return new PostUpdateResponseDto(post, categoryListByPost);
    }

    /**
     * ,로 구분되어 있는 카테고리 분리
     * @param category
     * @return Stream<String>
     */
    @Transactional
    public Stream<String> categoryListToEntity(String category) {
        List<String> categoryList = Arrays.asList(category.split(","));
        return categoryList.stream();
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
     * @param postId
     * @return boolean
     */
    @Transactional
    public List<Post> createOfficial(Long postId) {
        List<Post> post = postRepository.findAll().stream()
                .filter(x -> x.getHearts() > 10 && x.getViews() > 10)
                .limit(3)
                .collect(Collectors.toList());

        post.forEach(Post::updateOfficial);
        return post;
    }
}
