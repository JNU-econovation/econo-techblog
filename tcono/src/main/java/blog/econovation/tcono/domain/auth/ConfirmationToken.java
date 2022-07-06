package blog.econovation.tcono.domain.auth;

import blog.econovation.tcono.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class ConfirmationToken extends BaseTimeEntity {

    private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @Column(length=6)
    private Long uid;

    @Column
    private LocalDateTime expirationDate;

    @Column
    private boolean expired;

    //일부러 FK 사용 안함
    @Column
    private String userId;

    public void setId(Long id) {
        this.id = id;
    }

    public static ConfirmationToken createEmailConfirmationToken(String userId){
        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.expirationDate = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE);
        confirmationToken.expired = false;
        confirmationToken.userId = userId;
        return confirmationToken;
    }
}
