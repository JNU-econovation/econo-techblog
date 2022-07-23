//package com.econovation.tcono.domain.comment;
//
//import com.econovation.tcono.domain.post.Post;
//import com.econovation.tcono.domain.post.PostRepository;
//import com.econovation.tcono.domain.user.User;
//import com.econovation.tcono.domain.user.UserRepository;
//import com.econovation.tcono.web.dto.CommentCreateRequestDto;
//import com.econovation.tcono.web.dto.CommentCreateResponseDto;
//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//import org.springframework.beans.factory.annotation.Autowired;
//import sun.security.krb5.internal.ccache.MemoryCredentialsCache;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//public class CommentMutationResolver implements GraphQLMutationResolver {
//    private static final String NOT_FOUND_USER_MESSAGE = "해당 유저는 존재하지 않습니다";
//    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지는 존재하지 않습니다.";
//
//    @Autowired
//    private CommentRepository commentRepository;
//    private UserRepository userRepository;
//    private PostRepository postRepository;
//
//    @Transactional
//    public CommentCreateResponseDto createCommentsByPostId(CommentCreateRequestDto commentCreateRequestDto) {
//
//        User user = userRepository.findById(commentCreateRequestDto.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
//
//        Post post = postRepository.findById(commentCreateRequestDto.getPostId())
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
//
//
//        //댓글조차 없는데 대댓글을 달려고 하는 경우 -> 에러 처리
//        //대댓글이 있는데 댓글을 달려고 하는 경우 -> 에러 처리
//    }
//
//
//    public Comment saveComment(Comment comment) {
//
//        return commentRepository.save(comment);
//    }
//
//
//    public void remove(Long id) throws Exception {
//        Comment comment = commentRepository.findById(id)
//                .orElseThrow(() -> new Exception("댓글이 없습니다."));
//        comment.remove();
//        List<Comment> removableCommentList = comment.findRemovableList();
//        removableCommentList.forEach(removableComment -> commentRepository.delete(removableComment));
//    }
//
//}
//
//
//
//    /*
//    update : content만 수정해서 save
//    delete : depth 잘 확인해서 1
//     */
//