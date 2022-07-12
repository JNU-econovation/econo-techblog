package blog.econovation.tcono.domain.post;

import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.user.UserRepository;
import blog.econovation.tcono.web.dto.PostCreateRequestDto;
import blog.econovation.tcono.web.dto.PostCreateResponseDto;
import blog.econovation.tcono.web.dto.PostUpdateRequestDto;
import blog.econovation.tcono.web.dto.PostUpdateResponseDto;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import blog.econovation.tcono.domain.post.PostRepository;
import blog.econovation.tcono.domain.post.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
     * @param PostCreateRequestDto: postCreateRequestDto
     * @return Post
     */
    @Transactional
    public PostCreateResponseDto createPost(PostCreateRequestDto postCreateRequestDto) {
        User user = userRepository.findByuserEmail(postCreateRequestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        Post post = postRepository.save(postCreateRequestDto.toPostEntity(user));
        List<String> categoryNameList = Arrays.asList(postCreateRequestDto.getCategory().split(","));
        for (String categoryName : categoryNameList) {
            categoryRepository.save(postCreateRequestDto.toCategoryEntity(post, categoryName));
        }
        List<Category> categoryListByPost = categoryRepository.findByPost(post);
        return new PostCreateResponseDto(post, categoryListByPost);
    }

    /**
     * Post update 구현
     *
     * @param PostUpdateRequestDto: postUpdateRequestDto
     * @return PostResponseDto
     */
    @Transactional
    public PostUpdateResponseDto updatePost(Long id, PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        post.updatePost(postUpdateRequestDto.getContent(), postUpdateRequestDto.getTitle());
        List<String> categoryNameList = Arrays.asList(postUpdateRequestDto.getCategory().split(","));
        for (String categoryName : categoryNameList) {
            categoryRepository.save(postUpdateRequestDto.toCategoryEntity(post, categoryName));
        }
        return new PostUpdateResponseDto(post, postUpdateRequestDto.getCategory());
    }

    /**
     * Post 제거
     *
     * @param Long: postId
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
     * 좋아요 10 이상, views가 10 이상인 글 official로 등록
     *
     * @param Long: postId
     * @return boolean
     */
    @Transactional
    public void createOfficial(Long postId) {
        List<Post> post = postRepository.findAll().stream()
                .filter(x -> x.getHearts() > 10 && x.getViews() > 10)
                .collect(Collectors.toList());


    }

}
