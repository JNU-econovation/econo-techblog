package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.user.Role;
import com.econovation.tcono.domain.user.User;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
public class UserUpdateRequestDto {
    @NotBlank
    private String userEmail;

    @NotNull
    @Range(min =1, max = 50)
    private Long year;

    @NotNull
    private String userName;

    @NotNull
    private Role role;


    public UserUpdateRequestDto(String userEmail, Long year, String userName,Role role) {
        this.userEmail = userEmail;
        this.year = year;
        this.userName = userName;
        this.role = role;
    }

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .year(year)
                .userName(userName)
                .role(role)
                .build();
    }
}
