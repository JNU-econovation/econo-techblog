package com.econovation.tcono.domain.post;

import com.econovation.tcono.domain.user.User;
import com.econovation.tcono.web.dto.PostCreateRequestDto;
import com.econovation.tcono.web.dto.PostCreateResponseDto;
import org.jboss.jandex.Main;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p")
    List<Post> findPosts(Pageable pageable);

    @Query("select p from Post p where p.mainCategory= :mainCategory")
    List<Post> findAllByMainCategory(@Param("mainCategory") MainCategory mainCategory,Pageable pageable);


    @Query("select p from Post p where p.id=:id")
    Optional<Post> findById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Post p set p.views = p.views + 1 where p.id = :id")
    int updateViews(@Param("id")Long id);

    List<Post> findByTitleContaining(String keyword, Pageable pageable);

    @Query("select p from Post p where p.userId=:userId")
    List<Post> findByUserId(@Param("userId") Long userId);

    @Query("select count(p) from Post p")
    Long countPosts();

}
