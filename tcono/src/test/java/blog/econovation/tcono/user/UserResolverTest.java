package blog.econovation.tcono.user;

import blog.econovation.tcono.domain.user.User;
import blog.econovation.tcono.domain.user.UserMutationResolver;
import blog.econovation.tcono.domain.user.UserQueryResolver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional  // resetAutoIncrement() 실행을 위해 필요
public class UserResolverTest {
    /**
     * Arrange
     * ACT
     * Assert
     */
//  테스트시 핑요한  Resolver Instance 생성
    @Before
    public void createUserResolver() {
//        given  : arrange
        @InjectMocks
        private UserMutationResolver userMutationResolver;

        @InjectMocks
        private UserQueryResolver userQueryResolver;

        @Mock
        UserRepository userRepository;
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    //    회원가입 테스트 (  UserResolver 내부 동작만 테스트하는 것이다. 인증 테스트는 별개로 진행한다. )
    @Test
    @Transactional
    public void createUserTest() {
//        given : when
        User user = User.builder()
                .userEmail("Test@gmail.com")
                .password("1234")
                .year(20)
                .userName("이서현");
        when(userMutationResolver.createUser(user)).thenReturn(user);
//        when : act
        User findUser = userQueryResoler.findUserById(1L);
//        then: assert
        assertThat(findUser.getName()).isEqualto(user.getUserName());
    }

    //     회원Id조회 테스트
    @Test
    @Transactional
    public void findUserById() {
        //        given : when
        User user = User.builder()
                .userEmail("Test@gmail.com")
                .password("1234")
                .year(20)
                .userName("이서현");

        User savedUser = userRepository.save(user);

    //        when : act
        User findUser = userRepository.findById(user.getId())
                    .orElseThrow(()-> new IllegalArgumentException("Wrong UserId:< " + user.getId() + ">"));
//    then
        assertThat(findUser.getName()).isEqualTo("이서현");
        assertThat(findUser.getYear().isEqualto(20));
        assertThat(findUser.getEmail().isEqualto("Test@gmail.com"));
}
    // 회원이름조회 테스트
    @Test
    @Transactional
    public void findUserByName() {
        //        given : when
        User user = User.builder()
                .userEmail("Test@gmail.com")
                .password("1234")
                .year(20)
                .userName("이서현");
        User savedUser = userRepository.save(user);

        //        when : act
        User findUser = userRepository.findById(user.getuserName())
                .orElseThrow(()-> new IllegalArgumentException("Wrong UserId:< " + user.getId() + ">"));
//    then
        assertThat(user.getName()).isEqualTo("이서현");
        assertThat(user.getYear().isEqualto(20));
        assertThat(user.getEmail().isEqualto("Test@gmail.com"));
    }

    //    회원가입 인증 테스트
    //    랜덤 키값을 형성하기 때문에 함수가 호출됐는지를 테스트한다.
    @Test(expected = NullPointerException.class)
    @Transactional
    public void confirmEmailTest(){
        EmailMutationResolver emailMutationResolverMocks = mock(EmailMutationResolver.class);
        doThrow(NullPointerException.class)
                .when(emailMutationResolverMocks);
        verify(emailMutationResolverMocks,times(1));
    }
//  로그인 테스트

//  회원 정보 수정 테스트
    @Test
    @Transactional
    public void updateUser(){
        User user1 = User.builder()
                .userEmail("Test1@gmail.com")
                .password("123")
                .year(22)
                .userName("이서현1");

        User user2 = User.builder()
                .userEmail("Test2@gmail.com")
                .password("12345")
                .year(20)
                .userName("이서현2");
        userRepositort.save(user1);
        userRepository.update(user2);

        User findUser = userRepository.findByName("이서현1");
        asseertThat(findUser.getName()).isEqualTo(user2.getName());
    }

//  회원정보 삭제 테스트
}
