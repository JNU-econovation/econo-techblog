//package com.econovation.tcono.domain.comment;
//
//import com.econovation.tcono.domain.post.Post;
//import com.econovation.tcono.domain.post.PostRepository;
//import com.econovation.tcono.domain.user.User;
//import com.econovation.tcono.domain.user.UserRepository;
//import com.econovation.tcono.web.dto.CommentCreateRequestDto;
//import com.econovation.tcono.web.dto.CommentCreateResponseDto;
//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//
//import javax.transaction.Transactional;
//
//public class CommentMutationResolver implements GraphQLMutationResolver {
//    private static final String NOT_FOUND_USER_MESSAGE ="해당 유저는 존재하지 않습니다";
//    private static final String NOT_FOUND_POST_MESSAGE ="해당 페이지는 존재하지 않습니다.";
//    private UserRepository userRepository;
//    private PostRepository postRepository;
//    @Transactional
//    public CommentCreateResponseDto createCommentsByPostId(CommentCreateRequestDto commentCreateRequestDto) {
//
<<<<<<< HEAD
//        User user= userRepository.findByuserEmail(commentCreateRequestDto.getUserEmail())
=======
//        User user= userRepository.findByUserEmail(commentCreateRequestDto())
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
//
//        Post post = postRepository.findById(commentCreateRequestDto.getPostId())
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));
//
//        if(commentCreateRequestDto.getDepth()==0){
//
//        }
//    }
//
//    /*
//    update : content만 수정해서 save
//    delete : depth 잘 확인해서 1
//     */
//}
