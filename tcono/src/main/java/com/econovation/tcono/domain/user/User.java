package com.econovation.tcono.domain.user;

import com.econovation.tcono.domain.BaseTimeEntity;
import com.econovation.tcono.web.dto.UserUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long id;

    @Column(nullable = false)
    @Range(min =1, max = 50)
    @NotNull
    private Long year;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "POST_ID")
//    private Post post;

    @Column(nullable = false)
    @NotNull
    private String userName;

    @Column(nullable = false)
    @NotNull
    private String password;

    @Column(nullable = false)
    @NotNull
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'USER'")
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean emailVerified;

    /**
     * 토큰 사용 만료
     */
    public void emailVerifiedSuccess(){
        emailVerified = true;
    }

    public void update(UserUpdateRequestDto userUpdateRequestDto){
        this.userEmail = userUpdateRequestDto.toEntity().getUserEmail();
        this.userName = userUpdateRequestDto.toEntity().getUserName();
        this.year = userUpdateRequestDto.toEntity().getYear();
    }
}