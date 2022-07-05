package blog.econovation.tcono.domain.post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostQueryResolver {

    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지가 없습니다.";
    private PostRepository postRepository;

    /**
     * Get Post By One postId
     * GraphQL Schema Query : (postId:Long):Post!
     *
     * @param Long : userId
     * @return Post
     */
    @Transactional
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    /**
     * Get Post By One postId
     * GraphQL Schema Query : user(postId:Long):Post!
     *
     * @param Long : userId
     * @return Post
     */
    @Transactional
    public Post findPostByPostId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        return post;
    }
}
