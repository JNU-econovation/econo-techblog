package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.auth.Password;
import blog.econovation.tcono.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
    @NotBlank
    private String userEmail;

    @NotNull
    @Password
    private String password;

    @NotNull
    @Range(min =1, max = 50)
    private Long year;

    @NotNull
    private String userName;

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .password(password)
                .year(year)
                .userName(userName).build();
    }

}
