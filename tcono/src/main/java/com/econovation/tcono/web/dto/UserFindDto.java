package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserFindDto {
    @Range(min =1, max = 50)
    private Long year;

    private String userName;

    public User toEntity(){
        return User.builder()
                .year(year)
                .userName(userName).
                build();
    }
}
