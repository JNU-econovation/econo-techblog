package com.econovation.tcono.domain.comment;

import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.post.PostRepository;
import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.domain.user.UserRepository;
import com.econovation.tcono.web.dto.*;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class CommentMutationResolver implements GraphQLMutationResolver {
    private static final String NOT_FOUND_USER_MESSAGE = "해당 유저는 존재하지 않습니다";
    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지는 존재하지 않습니다.";
    private static final String NOT_FOUND_COMMENT_MESSAGE = "해당 댓글은 존재하지 않습니다.";
    private static final String DELETE_COMMENT_MESSAGE = "해당 댓글은 삭제되었습니다.";

    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public User isUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));

        return user;
    }

    @Transactional
    public Post isPost(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        return post;
    }

    @Transactional
    public CommentResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto) {

        User user=isUser(commentCreateRequestDto.getUserId());
        Post post=isPost(commentCreateRequestDto.getPostId());

        Integer parentNumber= commentRepository.countByParent();
        if(parentNumber==null){
            Comment newComment=commentCreateRequestDto.toEntity(post,0);
            commentRepository.save(newComment);
            return new CommentResponseDto(newComment,user);
        }
        Comment newComment=commentCreateRequestDto.toEntity(post,parentNumber);
        commentRepository.save(newComment);
        return new CommentResponseDto(newComment,user);
    }

    @Transactional
    public CommentResponseDto createReply(ReplyCreateRequestDto replyCreateRequestDto){
        User user=isUser(replyCreateRequestDto.getUserId());
        Post post=isPost(replyCreateRequestDto.getPostId());

        Comment newComment=replyCreateRequestDto.toEntity(post);
        commentRepository.save(newComment);
        return new CommentResponseDto(newComment,user);
    }
    @Transactional
    public CommentResponseDto updateComment(CommentUpdateRequestDto commentUpdateRequestDto) {

        User user=isUser(commentUpdateRequestDto.getUserId());
        Post post=isPost(commentUpdateRequestDto.getPostId());

        Comment comment=commentRepository.findById(commentUpdateRequestDto.getCommentId())
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_COMMENT_MESSAGE));

        comment.updateComment(commentUpdateRequestDto.getContent());
        return new CommentResponseDto(comment,user);
    }

//    @Transactional
//    public Boolean deleteComment(CommentDeleteRequestDto commentDeleteRequestDto){
//        Comment comment = commentRepository.findById(commentDeleteRequestDto.getCommentId())
//                        .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_COMMENT_MESSAGE));
//        comment.remove();
//
//    }

}



    /*
    update : content만 수정해서 save
    delete : depth 잘 확인해서 1
     */

