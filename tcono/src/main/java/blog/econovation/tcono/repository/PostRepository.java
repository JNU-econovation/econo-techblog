package blog.econovation.tcono.repository;

import blog.econovation.tcono.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}


