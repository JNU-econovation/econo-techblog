package blog.econovation.tcono.domain.post;

import blog.econovation.tcono.domain.category.Category;
import blog.econovation.tcono.domain.category.CategoryPost;
import blog.econovation.tcono.domain.category.CategoryRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Transactional
public class PostMutationResolver implements GraphQLMutationResolver {
    private static final String NOT_FOUND_POST_MESSAGE = "페이지가 없습니다";
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;

//    createPost(content : String!,title:String!, categoty:[String!]!): Post!
//    deletePost(userId : ID):Boolean
//    updatePost(content : String!,title:String!, categoty:[String]): Int!
//    createCategoryByPostId(postId : ID!, category : String!) : Int

    @Transactional
    public Post createPost(Long postId, String content, String title, String category) {
        Post post = Post.create(postId, content, title);
        createCategoryByPostId(postId, category);
        postRepository.save(post);

        return post;
    }

    @Transactional
    public boolean deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        postRepository.delete(post);
        return true;
    }

    @Transactional
    public Long updatePost(Long postId, String content, String title, String category) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        createCategoryByPostId(postId, category);
        post.updatePost(content, title);
        return postId;
    }

    public String[] toList(String category) {
        String[] categoryList = category.split(",");
        return categoryList;
    }

    @Transactional
    public Long createCategoryByPostId(Long postId, String category) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
        //TODO
        //post에 있는 기존의 category 제거하는 로직
        //String 형태의 category 쪼개는 로직

        Category newCategory = Category.create(category, post);
        categoryRepository.save(newCategory);

        return postId;
    }

}
