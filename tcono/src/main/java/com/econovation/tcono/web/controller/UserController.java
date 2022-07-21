package com.econovation.tcono.web.controller;

import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.web.dto.UserCreateRequestDto;
import com.econovation.tcono.web.dto.UserFindDto;
import com.econovation.tcono.web.dto.UserUpdateRequestDto;
import com.econovation.tcono.service.LoginService;
import com.econovation.tcono.service.UserService;
import com.econovation.tcono.web.dto.UserLoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @GetMapping("/api/user/{userId}")
    public User findUserById(@PathVariable Long userId) { return userService.findUserById(userId);}

    @GetMapping("/api/user/pinCode/{pinCode}")
    public User findUserBypinCode(@PathVariable String pinCode) { return userService.findUserByPinCode(pinCode);}

    @GetMapping("/api/usernames/{userName}")
    public String findUserByUserName(@PathVariable String userName){
        List<User> findUser = userService.findUserByUserName(userName);
        return userName;
    }
    @GetMapping("/api/find-email/")
    public User findEmail(@Valid @ModelAttribute UserFindDto userFindDto){
        return userService.findUserByYearAndUserName(userFindDto);
    }

    @GetMapping("/api/user/email/{userEmail}")
    public User findUserByEmail(@PathVariable String userEmail) { return userService.findUserByUserEmail(userEmail);}

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @PutMapping("/api/user/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        return userService.updateUser(userId, userUpdateRequestDto);
    }

    @DeleteMapping("/api/user/{userId}")
    public Long deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return userId;
    }
//    ${도메인}/confirm-email?token=${token의 ID값}
//    으로 접근시 이메일 인증 로직으로 남겨준다.
    @GetMapping("/api/confirm-email/{token}")
    public void confirmEmail(@PathVariable String token) {
        log.info(token);
        userService.confirmEmail(token);
    }

    @PostMapping("/api/user")
    public User createUser(@RequestBody UserCreateRequestDto userCreateRequestDto){ return userService.createUser(userCreateRequestDto); }

    @PostMapping("/api/login")
    public User login(@RequestBody UserLoginRequestDto userLoginRequestDto, BindingResult bindingResult, HttpServletRequest request) {

        User loginMember = loginService.login(userLoginRequestDto.getUserEmail(),userLoginRequestDto.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            log.info(bindingResult.toString());
//            return "Login Fail";
            throw new IllegalArgumentException("LoginFail");
        }

        //로그인 성공 처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return loginMember;
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return request.changeSessionId();
    }

}
