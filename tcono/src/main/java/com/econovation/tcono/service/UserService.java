package com.econovation.tcono.service;

import com.econovation.tcono.domain.auth.ConfirmationToken;
import com.econovation.tcono.domain.auth.ConfirmationTokenRepository;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.web.dto.UserCreateRequestDto;
import com.econovation.tcono.web.dto.UserUpdateRequestDto;
import com.econovation.tcono.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private static final String EXIST_ALREADY_USER_MESSAGE = "해당 이메일은 이미 회원가입 돼 있습니다.";
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
        return userRepository.findByUserEmail(userEmail).get();
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
        Optional<User> existUserEmail = userRepository.findByUserEmail(user.getUserEmail());

//        없는 이메일일 경우에만 회원가입을 실시
        if(!existUserEmail.toString().isEmpty()){
            User save = userRepository.save(user);
            UUID token = confirmationTokenService.createEmailConfirmationToken(save.getId(), save.getUserEmail());
            log.info("userId : ", save.getId());
            return save;
        }
        throw new IllegalArgumentException(EXIST_ALREADY_USER_MESSAGE);
    }

//    ----------------------------------------


    /**
     * Auth Process : confirmEmail and make Auth process
     * @Param token : String!
     * @return vpod
     */
    public void confirmEmail(String token) {
        UUID uuid = UUID.fromString(token);
        ConfirmationToken findConfirmationToken = confirmationTokenService.findByIdAndExpirationDateAfterAndExpired(uuid);
        log.info(String.valueOf(findConfirmationToken.getId()));
//        여기서 UserId가 Null Exception
        log.info(String.valueOf(findConfirmationToken.getUserId()));
        User findUser = userRepository.findById(findConfirmationToken.getUserId())
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        findConfirmationToken.useToken();	// 토큰 만료 로직을 구현해주면 된다. ex) expired 값을 true로 변경
        findUser.emailVerifiedSuccess();  // 유저의 이메일 인증 값 변경 로직을 구현해주면 된다. ex) emailVerified 값을 true로 변경
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
    public User updateUser(Long userId,UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        user.update(userUpdateRequestDto);
        return user;
    }

    /**
     * update User's Role (ex. ADMIN -> USER,  GUEST -> USER)
     * @Param userId : Int!, role : Role!
     * @return enum Role
     */
    /**
     *
    public String updateUserRole(Long userId, String Role) {
        log.info("Role : " + this.Role + "-> " + Role);
        return Role;
    }
    */


}
