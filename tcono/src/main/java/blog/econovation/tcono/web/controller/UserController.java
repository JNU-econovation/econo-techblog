package blog.econovation.tcono.web.controller;

import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.service.UserService;
import blog.econovation.tcono.web.dto.UserCreateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {
    findUserById(id : ID!) : User!
    findUserByUserName(userName : String!) : [User]!
    findUserByUserEmail(userEmail : String!) : User!
    updateUser(userEmail : String!, password : String!, year : Int!, userName : String!) : User!
    userLogin(userEmail : String, password : String!) : Boolean!
    deleteUserById(userId: Int!): Boolean!
    updateUserRole(userId : Int!, role : Role!): Role!
    confirmEmail(token : String!) : Void!

    private final UserService userService;

    @GetMapping("/{userId}")
    public Long findUserById(@PathVariable Long userId, Model model){
        return userService.findUserById(userId);
    }

    @GetMapping("/{userName}")
    public String findUserByUserName(@PathVariable String userName){

    }

    @PostMapping("/user")
    public Long createUser(UserCreateRequestDto userCreateRequestDto){

    }

}
