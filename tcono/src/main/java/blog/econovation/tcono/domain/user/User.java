package blog.econovation.tcono.domain.user;

import blog.econovation.tcono.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.hibernate.validator.constraints.Range;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User")
@DynamicInsert
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long id;

    @Column(nullable = false)
    @Range(min =1, max = 50)
    private Long year;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "POST_ID")
//    private Post post;

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