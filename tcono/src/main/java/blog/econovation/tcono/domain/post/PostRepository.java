package blog.econovation.tcono.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByMainCategory(MainCategory mainCategory);
}
