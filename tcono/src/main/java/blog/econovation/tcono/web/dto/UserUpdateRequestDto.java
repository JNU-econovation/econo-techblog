package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.auth.Password;
import blog.econovation.tcono.domain.user.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
                .userName(userEmail).build();
    }
}