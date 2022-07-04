package blog.econovation.tcono.domain.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {

    private static final String NOT_FOUND_USER_MESSAGE = "해당 회원을 찾을 수 없습니다";
    private final UserRepository userRepository;

    /**
     * Get User One Data
     * GraphQL Schema Query : user(userId:Long):User!
     * @param userId
     * @return User
     */
    @Transactional
    public User findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        return user;
    }



    /**
     * Get User One userName
     * GraphQL Schema Query : user(userId:Long):User!
     * @param String : userName
     * @return List<UserResponseDto>
     */
    @Transactional
    public List<UserResponseDto> findUserByUserName(String userName) {
        List<User> users = userRepository.findByUserName(userName);
        List<UserResponseDto> findUser = users.stream().map(UserResponseDto).collect(Collectors.toList());
        if(findUser.isEmpty()){
            throw new IllegalArgumentException(NOT_FOUND_USER_MESSAGE);
        }
        return findUser;
    }

    public User findUserByUserEmail(String userEmail) {

    }

}
