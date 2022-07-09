package blog.econovation.tcono.service;

import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    /**
     * Login User Process
     * @Param userEmail : String, password : String!
     * @return User, Null처리
     */

    public User login(String email, String password) {
        return userRepository.findByuserEmail(email).stream()
                .filter(m -> m.getPassword().equals(password))
                .findAny().orElse(null);
    }
}