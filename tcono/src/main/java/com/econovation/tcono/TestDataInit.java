package com.econovation.tcono;


import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    @Transactional
    public void init() {
        User user = new User();
        User findUser = user.builder()
                .userEmail("ymecca730135@gmail.com")
                .password("12a3f2awkcnwi4!")
                .year(23L)
                .userName("이서현")
                .pinCode("1234")
                .build();
        userRepository.save(findUser);
    }
}