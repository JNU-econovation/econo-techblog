package blog.econovation.tcono.user;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;


public class UserResolverTest {

/**
 * Arrange
 * ACT
 * Assert
 */
//회원 가입 테스트

    @Before
    public void createUserResolver(){
//        given  : arrange
        @InjectMocks
        private UserMutationResolver userMutationResolver;

        @InjectMocks
        private UserQueryResolver userQueryResolver;

        @Mock
        UserRepository userRepository;
    }
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    //    회원가입 테스트
    //    랜덤 키값을 형성하기 때문에 함수가 호출됐는지를 테스트한다.
    @Test
    @Transactional
    public void createUserTest(){
//        given : when
        User user = User.builder()
                .userEmail("Test@gmail.com")
                .password("1234")
                .year(20)
                .userName("이서현");
        when(userMutationResolver.createUser(user)).thenReturn(user);
//        when : act
        User findUser = userQueryResoler.findByUserEmail(1L);
//        then: assert
        assertThat(findUser.getName()).isEqualto(user.getUserName());
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
