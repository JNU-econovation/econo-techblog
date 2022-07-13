package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserLoginRequestDto {
    private String password;
    private String userEmail;

    @Builder
    public UserLoginRequestDto(String password, String userEmail) {
        this.password = password;
        this.userEmail = userEmail;
    }


    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .password(password).build();
    }
}
