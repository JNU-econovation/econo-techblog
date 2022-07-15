package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.user.User;
<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/web/dto/UserUpdateRequestDto.java
import lombok.AccessLevel;
=======
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/blog/econovation/tcono/web/dto/UserUpdateRequestDto.java
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

    public UserUpdateRequestDto(String userEmail, Long year, String userName) {
        this.userEmail = userEmail;
        this.year = year;
        this.userName = userName;
    }

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .year(year)
                .userName(userName).build();
    }
}
