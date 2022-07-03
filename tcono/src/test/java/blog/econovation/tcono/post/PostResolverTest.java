package blog.econovation.tcono.post;

import blog.econovation.tcono.domain.post.User;
import blog.econovation.tcono.domain.post.UserMutationResolver;
import blog.econovation.tcono.domain.post.UserQueryResolver;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional  // resetAutoIncrement() 실행을 위해 필요
public class PostResolverTest {
    @Before
    public void createUserResolver() {
//        given  : arrange
        @InjectMocks
        private PostMutationResolver postMutationResolver;

        @InjectMocks
        private PostQueryResolver postQueryResolver;

        @Mock
        UserRepository postRepository;

    }


    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Transactional
    public void createUserTest() {
//        given : when
                Post post = Post.builder()
                .content("거꾸로해도우영우,인도인토마토별똥별우영우")
                .title("인도인토마토별똥별우영우")
                .category(new String[]{"인도인", "별똥별", "토마토", "우영우"});
        when(postMutationResolver.createUser(post)).thenReturn(post);
//        when : act
        Post findPost = postRepository.findById(1L)
                .orElseThrow(()-> new IllegalArgumentException("Wrong UserId:< " + post.getId() + ">"));
//        then: assert
        assertThat(findPost.getContet()).isEqualto(post.getUserName());
    }
    //     회원Id조회 테스트
    @Test
    @Transactional
    public void findPostByIdTest() {
        //        given : when
        Post post = Post.builder()
                .content("거꾸로해도우영우,인도인토마토별똥별우영우")
                .title("인도인토마토별똥별우영우")
                .category(new String[]{"인도인", "별똥별", "토마토", "우영우"});

        Post savedPost = postRepository.save(post);

        //        when : act
        Post findPost = postRepository.findById(post.getId())
                .orElseThrow(()-> new IllegalArgumentException("Wrong UserId:< " + post.getId() + ">"));
//    then
        assertThat(findPost.getContent()).isEqualTo(post.getContet());
        assertThat(findPost.getTitle().isEqualto(post.getTitle()));
        assertThat(findPost.getCategory().isEqualto(post.getCategory()));
    }

//    카테고리별 분류 테스트
    @Test
    @Transactional
    public void findPostByCategoryTest() {
        //        given : when
        Post post = Post.builder()
                .content("거꾸로해도우영우,인도인토마토별똥별우영우")
                .title("인도인토마토별똥별우영우")
                .category(new String[]{"인도인", "별똥별", "토마토", "우영우"});

        Post savedPost = postRepository.save(post);

        //        when : act
        Post findPost = postRepository.findById(post.getId())
                .orElseThrow(()-> new IllegalArgumentException("Wrong PostId:< " + post.getId() + ">"));
//    then
        assertThat(findPost).isEqualTo(post);
//        참조객체와 선언한 객체가 동일한지 테스트가 가능한지 해보고 안되면 아래 칼럼 하나하나 해볼것이다.
//        안좋은 방법인건 알지만 일단 한번 해보자.

//        assertThat(findPost.getContent()).isEqualTo(post.getContet());
//        assertThat(findPost.getTitle().isEqualto(post.getTitle()));
//        assertThat(findPost.getCategory().isEqualto(post.getCategory()));
    }

    // PostCreate시 Category DataBase에 추가됐는지 테스트
    @Test
    @Transactional
    public void createPostAndCreateCategoryTest() {
        //        given : when
        Post post = Post.builder()
                .content("거꾸로해도우영우,인도인토마토별똥별우영우")
                .title("기러기토마토스위스인도인별똥별우영우")
                .category(new String[]{"인도인", "별똥별", "토마토", "우영우"});

        when(postMutationResolver.createUser(post)).thenReturn(post);
        //        when : act
        Category findCategory = categoryRepository.findCategoryByPostId(post.getId())
                .orElseThrow(()-> new IllegalArgumentException("In creatingProcessWrong PostId:< " + post.getId() + ">"));
//    then
//        Category : categoryName  (Table : Columns)
        assertThat(findCategory).isEqualTo(post.getCategory());
    }


}
