package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDto {
    @NotEmpty
    private String userEmail;
    @NotEmpty
    private String password;

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .password(password).build();
    }
}
