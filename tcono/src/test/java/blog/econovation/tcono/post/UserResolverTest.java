package blog.econovation.tcono.post;

import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.user.UserMutationResolver;
import blog.econovation.tcono.domain.user.UserQueryResolver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


public class UserResolverTest {
    @Mock private User user;

/**
 * Arrange
 * ACT
 * Assert
 */
//회원 가입 테스트
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
//    Initializes objects annotated with Mockito annotations for given testClass: @Mock, @Spy, @Captor, @InjectMocks

    }
//    findUserByUserName(userName : String!) : [User]!

//    findUserByUserEmail(userEmail : String!) : User!

    @Before
    public void createResolver(){

//        given  : arrange
        UserMutationResolver userMutationResolver = new UserMutationResolver();
        UserQueryResolver userQueryResolver = new UserQueryResolver();
        @InjectMocks private UserMutationResolver;
        @InjectMocks private UserQueryResolver;

//        when : act


//        then : assert
        verify()
    }

    public void
    @Before
    @Test
    @Transactional
    public void

// 회원조회 테스트
    @Test
    @Transactional
    public void selectUserById(){

    }

//  로그인 테스트

//  회원 정보 수정 테스트

//  회원정보 열람 테스트

//  회원정보 삭제 테스트
}
