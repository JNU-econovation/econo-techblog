package com.econovation.tcono.post;

import com.econovation.tcono.domain.post.MainCategory;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("postRepository 테스트")
    void test() {
        Post post=Post.builder()
                .userId(1L)
                .content("spring")
                .title("hard")
                .mainCategory(MainCategory.TECH)
                .build();
        postRepository.save(post); // Entity의 값을 null로 insert함

        System.out.println(postRepository.findAll());
    }
}