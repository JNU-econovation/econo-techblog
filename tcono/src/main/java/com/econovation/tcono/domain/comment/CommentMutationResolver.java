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


    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public User getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));

        return user;
    }

    @Transactional
    public Post getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POST_MESSAGE));

        return post;
    }

    /**
     * 댓글 생성 기능
     *
     * @param commentCreateRequestDto : userId:Long, postId:Long, content:String
     * @return CommentResponseDto : commentId:Long, userName:String, postId: Long, content:String, parent:Int
     */
    @Transactional
    public CommentResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto) {

        User user = getUser(commentCreateRequestDto.getUserId());
        Post post = getPost(commentCreateRequestDto.getPostId());

        //댓글 그룹 번호 생성하기
        Integer parentNumber = commentRepository.findCommentGroup().orElse(0);

        Comment comment = commentCreateRequestDto.toEntity(post);
        comment.changeParent(parentNumber);

        commentRepository.save(comment);
//        return new CommentResponseDto(comment, user);
        return new CommentResponseDto(comment);
    }

    /**
     * 대댓글 생성 기능
     *
     * @param replyCreateRequestDto : userId:Long, postId:Long, content:String, parent:Int)
     * @return CommentResponseDto : commentId:Long, userName:String, postId: Long, content:String, parent:Int
     */

    @Transactional
    public CommentResponseDto createNestedComments(ReplyCreateRequestDto replyCreateRequestDto) {
        User user = getUser(replyCreateRequestDto.getUserId());
        Post post = getPost(replyCreateRequestDto.getPostId());

        Integer parentNumber = commentRepository.findCommentGroup()
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_COMMENT_MESSAGE));

        Integer seqNumber=commentRepository.findCommentsByParentAndSeq(parentNumber).get();


        Comment comment = replyCreateRequestDto.toEntity(post);
        comment.changeSeq(seqNumber);

        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }

    /**
     * 대/댓글 수정 기능
     *
     * @param commentUpdateRequestDto : commentId:Long, userId:Long, postId: Long, content:String
     * @return CommentResponseDto : commentId:Long, userName:String, postId: Long, content:String, parent:Int)
     */
    @Transactional
    public CommentResponseDto updateComment(CommentUpdateRequestDto commentUpdateRequestDto) {

        User user = getUser(commentUpdateRequestDto.getUserId());
        Post post = getPost(commentUpdateRequestDto.getPostId());

        Comment comment = commentRepository.findById(commentUpdateRequestDto.getCommentId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_COMMENT_MESSAGE));

        comment.updateComment(commentUpdateRequestDto.getContent());
        return new CommentResponseDto(comment);
    }
}



    /*
    update : content만 수정해서 save
    delete : depth 잘 확인해서 1
     */

