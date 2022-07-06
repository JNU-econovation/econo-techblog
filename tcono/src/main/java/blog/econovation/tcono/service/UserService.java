package blog.econovation.tcono.service;

import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.user.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Slf4j
@Component
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private static final String NOT_FOUND_USER_MESSAGE = "해당 회원을 찾을 수 없습니다";
    private static final String NOT_FOUND_EMAIL_MESSAGE = "해당 이메일을 찾을 수 없습니다.";
    private final UserRepository userRepository;

    /**
     * Get User By One userId
     * @param Long : userId
     * @return User
     */
    @Transactional
    public Long findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        return user.getId();
    }

    /**
     * Get User By One userName
     * @param String : userName
     * @return List<UserResponseDto>
     */
    @Transactional
    public List<UserResponseDto> findUserByUserName(String userName) {
        List<User> users = userRepository.findByUserName(userName);
        List<UserResponseDto> findUser = users.stream().map(user -> new UserResponseDto().).collect(Collectors.toList());
        if(findUser.isEmpty()){
            throw new IllegalArgumentException(NOT_FOUND_USER_MESSAGE);
        }
        return findUser;
    }

    /**
     * Get User By One userEmail
     * @param String : userEmail
     * @return User
     */
    @Transactional
    public User findUserByUserEmail(String userEmail) {
        User user = userRepository.findByuserEmail(userEmail)
                .orElse(null);
        return user;
    }

    /**
     * create One User Data
     * @Param userEmail : String!, password : String!, year : Int!, userName : String!
     * @return User
     *
     */
    public final createrUser(String userEmail, String password, int year, String userName) {

    }

    /**
     * delete One User Data
     * @Param userId
     * @return boolean
     */
    public Boolean deleteUserById(final Long userId) {
        return true;
    }

    /**
     * update One User Data
     * @Param userEmail : String!, password : String!, year : Int!, userName : String!
     * @return boolean
     */
    public User updateUser(String userEmail, String password, int year, String userName) {
        return User;
    }

    /**
     * Login User Process
     * @Param userEmail : String, password : String!
     * @return Boolean
     */
    public boolean userLogin() {
        return true;
    }

    /**
     * update User's Role (ex. ADMIN -> USER,  GUEST -> USER)
     * @Param userId : Int!, role : Role!
     * @return enum Role
     */
    public String updateUserRole(Long userId, String Role) {
        log.info("Role : " + this.Role + "-> " + Role);
        return Role;
    }

    /**
     * Auth Process : confirmEmail and make Auth process
     * @Param token : String!
     * @return vpod
     */
    public void confirmEmail(String token) {
    }
}
