package com.econovation.tcono.domain.user;

<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/domain/user/User.java
import com.econovation.tcono.domain.BaseTimeEntity;
import com.econovation.tcono.domain.post.Post;
=======

import com.econovation.tcono.domain.BaseTimeEntity;
import com.econovation.tcono.web.dto.UserUpdateRequestDto;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/blog/econovation/tcono/domain/user/User.java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Range;

<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/domain/user/User.java
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/blog/econovation/tcono/domain/user/User.java

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/domain/user/User.java
@Table(name="Users")
=======
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/blog/econovation/tcono/domain/user/User.java
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POST_ID")
    private List<Post> postList=new ArrayList<>();

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