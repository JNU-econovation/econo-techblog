package blog.econovation.tcono.web.dto;

import blog.econovation.tcono.domain.auth.Password;
import lombok.Builder.Default;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
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
}
