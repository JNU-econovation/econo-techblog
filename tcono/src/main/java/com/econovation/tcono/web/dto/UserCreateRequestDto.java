package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.auth.Password;
import com.econovation.tcono.domain.user.User;
<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/web/dto/UserCreateRequestDto.java
import lombok.AccessLevel;
=======
import lombok.AllArgsConstructor;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/blog/econovation/tcono/web/dto/UserCreateRequestDto.java
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequestDto {


    @NotEmpty
    private String userEmail;

    @NotEmpty
    @Password
    private String password;

    @NotEmpty
    @Range(min =1, max = 50)
    private Long year;

    @NotEmpty
    private String userName;

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .password(password)
                .year(year)
                .userName(userName).build();
    }

}
