package com.econovation.tcono.domain.user;

import com.econovation.tcono.domain.BaseTimeEntity;
import com.econovation.tcono.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
@DynamicInsert
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long id;

    @Column(nullable = false)
    @Range(min =1, max = 50)
    private Long year;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POST_ID")
    private List<Post> postList=new ArrayList<>();

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("'ROLE_GUEST'")
    private Role role;

    @Column(nullable = false)
    @ColumnDefault("'false'")
    private boolean emailVerified;

    /**
     * 토큰 사용 만료
     */
    public boolean emailVerifiedSuccess(){
        emailVerified = true;
        return true;
    }
}