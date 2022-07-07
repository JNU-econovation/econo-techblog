package blog.econovation.tcono.service;

import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.user.UserRepository;
import blog.econovation.tcono.web.dto.UserUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@AllArgsConstructor
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private static final String NOT_FOUND_USER_MESSAGE = "해당 회원을 찾을 수 없습니다";
    private static final String NOT_FOUND_EMAIL_MESSAGE = "해당 이메일을 찾을 수 없습니다.";

    private final UserRepository userRepository;
    private final ConfirmationTokenService confirmationTokenService;

    /**
     * Get User By One userId
     * @param Long : userId
     * @return User
     */
    @Transactional
    public User findUserById(Long id) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        log.info("이름 : " + findUser.getUserName() + "\n기수 : " + findUser.getYear() + "\n이메일 : " + findUser.getUserEmail() + "비밀번호 : " + findUser.getPassword());
        return findUser;
    }

    /**
     * Get User By One userName
     * @param String : userName
     * @return List<UserResponseDto>
     * 동명이인이 있을 수 있어서 List를 받는다.
     */
    @Transactional
    public List<User> findUserByUserName(String userName) {
        List<User> users = userRepository.findByUserName(userName);
//        List<UserResponseDto> findUser = users.stream().map(user -> new UserResponseDto.builder()
//                .year(user.getYear())
//                .userName(user.getUserName())
//                .password(user.getPassword())
//                .userEmail(user.getUserEmail())
//                .build()).collect(Collectors.toList());
        if(users.isEmpty()){
            throw new IllegalArgumentException(NOT_FOUND_USER_MESSAGE);
        }
        return users;
    }

    /**
     * Get User By One userEmail
     * @param String : userEmail
     * @return User
     */
    @Transactional
    public User findUserByUserEmail(String userEmail) {
        User findUser = userRepository.findByuserEmail(userEmail);
        return findUser;
    }
//    ----User Authentication------------------------------------------------------------------

    /**
     * create One User Data
     * @Param userEmail : String!, password : String!, year : Int!, userName : String!
     * @return User
     *
     */
//    @Transactional
//    public Long createrUser(UserCreateRequestDto userCreateRequestDto) {
//
//        return user.getId();
//    }

    /**
     * Auth Process : confirmEmail and make Auth process
     * @Param token : String!
     * @return vpod
     */
    public void confirmEmail(String token) {
        confirmationTokenService.findByIdAndExpirationDateAfterAndExpired(token);
    }


//    -------------------------------------------------------------------------------------
    /**
     * delete One User Data
     * @Param userId
     * @return void
     */
    public void deleteUserById(final Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        userRepository.delete(user);
    }

    /**
     * update One User Data
     * @Param userEmail : String!, password : String!, year : Int!, userName : String!
     * @return boolean
     */
    public User updateUser(UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.save(userUpdateRequestDto.toEntity());
        return user;
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
    /**
    public String updateUserRole(Long userId, String Role) {
        log.info("Role : " + this.Role + "-> " + Role);
        return Role;
    }
    */


}
