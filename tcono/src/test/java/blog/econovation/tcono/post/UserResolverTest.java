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
    @Mock
    private User user;
    @Mock
    UserRepository userRepository;
/**
 * Arrange
 * ACT
 * Assert
 */
//회원 가입 테스트
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);

    }

    @Before
    public void createResolver(){
//        given  : arrange


        @InjectMocks
        private UserMutationResolver userMutationResolver;

        @InjectMocks
        private UserQueryResolver userQueryResolver;

//        when : act


//        then : assert
        verify()
    }
//    회원가입 테스트
    //    랜덤 키값을 형성하기 때문에 함수가 호출됐는지를 테스트한다.
    @Test
    @Transactional
    public void (){

    }

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
