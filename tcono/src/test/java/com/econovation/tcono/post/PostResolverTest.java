package com.econovation.tcono.post;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional  // resetAutoIncrement() 실행을 위해 필요
public class PostResolverTest {

    @InjectMocks
    private PostMutationResolver postMutationResolver;

    @InjectMocks
    private PostQueryResolver postQueryResolver;

    @Mock
    PostRepository postRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Transactional
    public void createPostTest() {
//        given : when
        Post post = Post.builder()
        .content("거꾸로해도우영우,인도인토마토별똥별우영우")
        .title("인도인토마토별똥별우영우")
        .category(new String[]{"인도인", "별똥별", "토마토", "우영우"});

        when(postMutationResolver.createPost(post)).thenReturn(post);
//        when : act
        Post findPost = postRepository.findById(1L)
                .orElseThrow(()-> new IllegalArgumentException("Wrong UserId:< " + post.getId() + ">"));
//        then: assert
        assertTrue(findPost.getContet()).isEqualto(post.getUserName());
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
        assertTrue(findPost.getContent().is(equalTo(post.getContet())));
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

        when(postMutationResolver.createPost(post)).thenReturn(post);
        //        when : act
        Category findCategory = categoryRepository.findCategoryByPostId(post.getId())
                .orElseThrow(()-> new IllegalArgumentException("In creatingProcessWrong PostId:< " + post.getId() + ">"));
//    then
//        Category : categoryName  (Table : Columns)
        assertThat(findCategory.getCategoryName(),post.getCategory());
    }

    @Test
    @Transactional
    public void updatePostTest(){
//        given : when
        Post post1 = Post.builder()
                .content("거꾸로해도우영우,인도인토마토별똥별우영우")
                .title("기러기토마토스위스인도인별똥별우영우")
                .category(new String[]{"인도인", "별똥별", "토마토", "우영우"});
        Post createdPost = postMutationResolver.createPost(post);
        Post post2 = Post.builder()
                .content("거꾸로해도우영우2,인도인토마토별똥별우영우2")
                .title("기러기토마토스위스인도인별똥별우영우2")
                .category(new String[]{"인도인2", "별똥별2", "토마토2", "우영우2"});
        when(postMutationResolver.updatePost(post2)).thenReturn(post2);
//        when : act
        Post findPost = postRepository.findById(post1.getId());
//        then : assert
        assertThat(findPost.getContent(), post2.getContent());
    }

    @Test
    @Transactional
    public void deletePostTest(){
//        given :
        Post post = Post.builder()
                .content("거꾸로해도우영우,인도인토마토별똥별우영우")
                .title("기러기토마토스위스인도인별똥별우영우")
                .category(new String[]{"인도인", "별똥별", "토마토", "우영우"});
        Post createdPost = postMutationResolver.createPost(post);
        int deletedId = postRepository.delete(post);
//        when : act
        Post findPost = postRepository.findCategoryByPostId(post.getId())
                .orElseThrow(()-> new IllegalArgumentException("In creatingProcessWrong PostId:< " + post.getId() + ">"));
//        then : assert
        assertEquals(findPost.getContent(),null);
    }


}
