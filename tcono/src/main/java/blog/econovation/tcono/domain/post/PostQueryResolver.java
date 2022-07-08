package blog.econovation.tcono.domain.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";
    private final PostRepository postRepository;

    /**
     * @param MainCategory: mainCategory
     * @return List<Post>
     * 각 대분류에 맞는 Post 보내기
     */

    @Transactional
    public List<Post> findAllPosts(MainCategory mainCategory) {
        List<Post> post = postRepository.findByMainCategory(MainCategory.getMainCategory(mainCategory));
        return post;
    }

    /**
     * @param Long: postId
     * @return Post
     * 댓글, 다음 페이지, 이전 페이지에 대한 정보 보내는 거 추가해야 함
     */
    //TODO
    //
    @Transactional
    public Post findPostByPosyId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        post.addViews();
        return post;
    }
}