package blog.econovation.tcono.graphql.post;

import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostQueryResolver {
    private PostRepository postRepository;

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    public Optional<Post> findPostByPostId(Long id) {
        return postRepository.findById(id);
    }
}
