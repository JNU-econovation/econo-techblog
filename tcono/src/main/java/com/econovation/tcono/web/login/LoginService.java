package com.econovation.tcono.web.login;

import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    /**
     * @return null 로그인 실패
     */
    public User login(String email, String password) {
        return userRepository.findByuserEmail(email).stream()
                .filter(m -> m.getPassword().equals(password))
                .findAny().orElse(null);
    }
}