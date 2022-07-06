package blog.econovation.tcono.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserCreateRequestDto {
    @NotBlank
    private String userName;

    @NotNull

    private String password;


}
//    createUser(userEmail : String!, password : String!, year : Int!, userName : String!) : User!
