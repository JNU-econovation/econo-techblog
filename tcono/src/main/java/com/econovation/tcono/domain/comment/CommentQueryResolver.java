//package com.econovation.tcono.domain.comment;
//
//import com.econovation.tcono.domain.post.Post;
//import com.econovation.tcono.domain.post.PostRepository;
//import com.econovation.tcono.domain.user.UserRepository;
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//public class CommentQueryResolver implements GraphQLQueryResolver {
////    private static final String NOT_FOUND_USER_MESSAGE = "해당 유저는 존재하지 않습니다";
////    private static final String NOT_FOUND_POST_MESSAGE = "해당 페이지는 존재하지 않습니다.";
//    private static final String NOT_FOUND_POST_USER = "해당 댓글은 존재하지 않습니다.";
//    private CommentRepository commentRepository;
//    private UserRepository userRepository;
//    private PostRepository postRepository;
//
//    @Transactional
//    public Comment findCommentById(Long commentId) throws Exception {
//        return commentRepository.findById(commentId)
//                .orElseThrow(() -> new Exception("댓글이 없습니다."));
//    }
//
//
//    @Transactional
//    public List<Comment> findAllComment() {
//        return commentRepository.findAll();
//    }
//
//    //== 비즈니스 로직 ==//
//    public List<Comment> findRemovableList() {
//
//        List<Comment> result = new ArrayList<>();
//
//        Optional.ofNullable(this.parent).ifPresentOrElse(
//
//                parentComment ->{//대댓글인 경우 (부모가 존재하는 경우)
//                    if( parentComment.isRemoved()&& parentComment.isAllChildRemoved()){
//                        result.addAll(parentComment.getChildList());
//                        result.add(parentComment);
//                    }
//                },
//
//                () -> {//댓글인 경우
//                    if (isAllChildRemoved()) {
//                        result.add(this);
//                        result.addAll(this.getChildList());
//                    }
//                }
//        );
//
//        return result;
//    }
//
//
//    //모든 자식 댓글이 삭제되었는지 판단
//    private boolean isAllChildRemoved() {
//        return getChildList().stream()
//                .map(Comment::isRemoved)//지워졌는지 여부로 바꾼다
//                .filter(isRemove -> !isRemove)//지워졌으면 true, 안지워졌으면 false이다. 따라서 filter에 걸러지는 것은 false인 녀석들이고, 있다면 false를 없다면 orElse를 통해 true를 반환한다.
//                .findAny()//지워지지 않은게 하나라도 있다면 false를 반환
//                .orElse(true);//모두 지워졌다면 true를 반환
//
//    }

//}

