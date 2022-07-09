package blog.econovation.tcono.service;

import blog.econovation.tcono.domain.auth.ConfirmationToken;
import blog.econovation.tcono.domain.auth.ConfirmationTokenRepository;
import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.user.UserRepository;
import blog.econovation.tcono.web.dto.UserCreateRequestDto;
import blog.econovation.tcono.web.dto.UserLoginRequestDto;
import blog.econovation.tcono.web.dto.UserUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private static final String NOT_FOUND_USER_MESSAGE = "해당 회원을 찾을 수 없습니다";
    private static final String NOT_FOUND_EMAIL_MESSAGE = "해당 이메일을 찾을 수 없습니다.";
    private static final String NOT_CORRECT_USER_MESSAGE = "비밀번호나 이메일이 일치하지 않습니다.";

    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
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
        Optional<User> findUser = userRepository.findByuserEmail(userEmail);
        return findUser.get();
    }
//    ----User Authentication------------------------------------------------------------------

    /**
     * create One User Data
     * @Param userEmail : String!, password : String!, year : Int!, userName : String!
     * @return User
     */
    @Transactional
    public User createUser(UserCreateRequestDto userCreateRequestDto) {
//        이메일 인증 절차
        User user = userCreateRequestDto.toEntity();
//        중복 이메일 검사
        User existUserEmail = userRepository.findByuserEmail(user.getUserEmail())
                .ofNullable(user)
                .get();
//        없는 이메일일 경우에만 회원가입을 실시
        if(!existUserEmail.toString().isEmpty()){
            UUID token = confirmationTokenService.createEmailConfirmationToken(user.getId(), user.getUserEmail());
            return userRepository.save(user);
        }
        throw new IllegalArgumentException(NOT_FOUND_USER_MESSAGE);
//        이후에 DB삽입
//       return user.getId();
    }
    /**
     * Login User Process
     * @Param userEmail : String, password : String!
     * @return Boolean
     */
    public String login(UserLoginRequestDto userLoginRequestDto) {
        User user = userLoginRequestDto.toEntity();
        String userEmail = user.getUserEmail();
        String password = user.getPassword();
//        password Hash

        User findUser = userRepository.findByuserEmail(userEmail).get();
//        회원 정보 DB 비교
        boolean isUser = findUser.getPassword().equals(password);

        if(isUser){
            return "Success";
        }
        throw new IllegalArgumentException(NOT_CORRECT_USER_MESSAGE);
    }

//    ----------------------------------------


    /**
     * Auth Process : confirmEmail and make Auth process
     * @Param token : String!
     * @return vpod
     */
    public boolean confirmEmail(String token) {
        ConfirmationToken findConfirmationToken = confirmationTokenService.findByIdAndExpirationDateAfterAndExpired(token);
        User findUser = findUserById(findConfirmationToken.getUserId());
        findConfirmationToken.useToken();	// 토큰 만료 로직을 구현해주면 된다. ex) expired 값을 true로 변경
        // 유저의 이메일 인증 값 변경 로직을 구현해주면 된다. ex) emailVerified 값을 true로 변경
        return findUser.emailVerifiedSuccess();
    }


//    -------------------------------------------------------------------------------------
    /**
     * delete One User Data
     * @Param userId
     * @return void
     */
    public void deleteUserById(final Long userId) {
//        관리자만 삭제할 수 있게 관리자 인증 추가 예정
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
