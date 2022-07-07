package blog.econovation.tcono.web.controller;

import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.service.UserService;
import blog.econovation.tcono.web.dto.UserCreateRequestDto;
import blog.econovation.tcono.web.dto.UserResponseDto;
import blog.econovation.tcono.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}")
    public Long findUserById(@PathVariable Long userId, Model model) {
        User findUser = userService.findUserById(userId);
        model.addAttribute("user", findUser);
        return findUser.getId();
    }

    @GetMapping("/users/{userName}")
    public String findUserByUserName(@PathVariable String userName, Model model) {
        List<User> findUser = userService.findUserByUserName(userName);
        model.addAttribute("user", findUser);
        return userName;
    }

    @GetMapping("/user/{userEmail}")
    public String findUserByUserEmail(String userEmail, Model model) {
        User user = userService.findUserByUserEmail(userEmail);
        model.addAttribute("user", user);
        return user.getUserEmail();
    }

    @PutMapping("/user")
    public Long updateUser(@Valid @ModelAttribute UserUpdateRequestDto userUpdateRequestDto, Model model) {
        User updatedUser = userService.updateUser(userUpdateRequestDto);
        model.addAttribute("user", updatedUser);
        return updatedUser.getId();
    }

    @DeleteMapping("/user/{userId}")
    public Long deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return userId;
    }

//    ${도메인}/confirm-email?token=${token의 ID값}
//    으로 접근시 이메일 인증 로직으로 남겨준다.
    @GetMapping("/confirm-email")
    public void confirmEmail(@Valid @RequestParam String token) {
        userService.confirmEmail(token);
    }

}
