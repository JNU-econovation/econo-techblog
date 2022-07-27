package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private Long year;
    private String userName;
    private String password;
    private String userEmail;

    @Builder
    public UserResponseDto(Long year, String userName, String password, String userEmail) {
        this.year = year;
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
    }

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .year(year)
                .userName(userEmail).build();
    }
}
