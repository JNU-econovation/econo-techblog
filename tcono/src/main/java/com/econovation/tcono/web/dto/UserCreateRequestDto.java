package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.auth.Password;
import com.econovation.tcono.domain.user.Role;
import com.econovation.tcono.domain.user.User;
import lombok.AllArgsConstructor;
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

    @NotEmpty
    private String pinCode;

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .password(password)
                .year(year)
                .pinCode(pinCode)
                .role(Role.GUEST)
                .userName(userName).build();
    }
}
