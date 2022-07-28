package com.econovation.tcono.Interceptor.service;

import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private static final String USER_LOGIN_FAIL_MESSAGE = "로그인을 실패하였습니다.";
    /**
     * Login User Process
     *
     * @return User, Null처리
     * @Param userEmail : String, password : String!
     */

    public User login(String email, String password) {
        List<User> collect = userRepository.findByUserEmail(email).stream()
                .filter(m -> m.getPassword().equals(password))
                .collect(Collectors.toList());
        User user = collect.stream().findFirst().get();
        return user;
//        Optional<User> firstUser = userRepository.findByUserEmail(email).stream().findFirst();
//        User user = firstUser.get();
//        if (user.getPassword().equals(password)) {
//            return user;
//        } else {
//            log.info("Login Fail 하였습니다리");
//            throw new IllegalArgumentException(USER_LOGIN_FAIL_MESSAGE);
//        }
//    }
    }
}