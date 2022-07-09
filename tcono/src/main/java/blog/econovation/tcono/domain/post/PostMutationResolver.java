package blog.econovation.tcono.domain.post;

import blog.econovation.tcono.domain.post.Post;
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

@Component
@RequiredArgsConstructor
public class PostMutationResolver implements GraphQLMutationResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;

    /**
     * Post create 구현
     *
     * @param PostCreateRequestDto: postCreateRequestDto
     * @return Post
     * 다음 글 보내주기 구현해야함.
     */
    @Transactional
    public PostCreateResponseDto createPost(PostCreateRequestDto postCreateRequestDto) {
        Post post = postRepository.save(postCreateRequestDto.toPostEntity());
        List<String> categoryNameList = Arrays.asList(postCreateRequestDto.getCategory().split(","));
        for (String categoryName : categoryNameList) {
            Category category = categoryRepository.save(postCreateRequestDto.toCategoryEntity(post));
        }
        return new PostCreateResponseDto(post, postCreateRequestDto.getCategory());
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
        post.updatePost(postUpdateRequestDto.getContent(),postUpdateRequestDto.getTitle());
        List<String> categoryNameList = Arrays.asList(postUpdateRequestDto.getCategory().split(","));
        for (String categoryName : categoryNameList) {
            Category category = categoryRepository.save(postUpdateRequestDto.toCategoryEntity(post));
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
     * 좋아요 증가 구현
     *
     * @param Long: postId
     * @return Int
     */
    @Transactional
    public int increaseLikePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        post.increaseLike();
        return post.getLike();
    }

    /**
     * 좋아요 취소 구현
     *
     * @param Long: postId
     * @return int
     */
    @Transactional
    public int decreaseLikePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        post.decreaseLike();
        return post.getLike();
    }

    /**
     * @param Long: postId
     * @return boolean
     */
    @Transactional
    public boolean isOfficial(Long postId) {

    }

}
