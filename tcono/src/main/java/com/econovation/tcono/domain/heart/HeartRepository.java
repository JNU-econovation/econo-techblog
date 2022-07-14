//package com.econovation.tcono.domain.heart;
//
//import com.econovation.tcono.domain.post.Post;
//import com.econovation.tcono.domain.user.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface HeartRepository extends JpaRepository<Heart, Long> {
//    /**
//     * 게시물(post)에 특정 회원이 회원(user)이 좋아요(heart)를 눌렀는지?
//     * @param user
//     * @param post
//     * @return Optional<Post>
//     */
//    Optional<Heart>findHeartByUserAndPost(User user, Post post);
//
//    /**
//     * 게시물(post)에 특정 회원(user)이 한 좋아요(heart)를 삭제
//     * @param user
//     * @param post
//     */
//    Optional<Heart> deleteHeartByUserAndPost(User user, Post post);
//
//
//}
