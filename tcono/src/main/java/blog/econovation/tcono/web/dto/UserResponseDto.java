package blog.econovation.tcono.web.dto;


import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long year;
    private String userName;
    private String password;
    private String userEmail;

    public UserResponseDto(Long year, String userName, String password, String userEmail) {
        this.year = year;
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
    }
}
