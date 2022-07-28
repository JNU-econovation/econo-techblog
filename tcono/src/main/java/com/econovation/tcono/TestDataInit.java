package com.econovation.tcono;


import com.econovation.tcono.domain.post.*;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    @Transactional
    public void initUser() {
        User user = new User();
        User findUser = user.builder()
                .userEmail("ymecca730135@gmail.com")
                .password("12a3f2awkcnwi4!")
                .year(23L)
                .userName("이서현")
                .pinCode("1234")
                .build();
        userRepository.save(findUser);

        User user2 = new User();
        User findUser2 = user.builder()
                .userEmail("ksoomin25@gmail.com")
                .password("pan145300!A")
                .year(21L)
                .userName("김수민")
                .pinCode("1234")
                .build();
        userRepository.save(findUser2);

        Post post = new Post();
        Post findPost = post.builder()
                .userId(1L)
                .content("ㅈㅂㅈㅂㅈㅂㅈㅂ 성공")
                .title("멋알")
                .mainCategory(MainCategory.getMainCategory(1))
                .build();

        postRepository.save(findPost);

        Category category1 = new Category();
        Category findCategory = Category.builder()
                .categoryName("이윤성")
                .post(postRepository.findById(1L).get())
                .build();

        categoryRepository.save(findCategory);

        Category category2 = new Category();
        Category findCategory2 = Category.builder()
                .categoryName("이혜은")
                .post(postRepository.findById(1L).get())
                .build();

        categoryRepository.save(findCategory2);

    }

}