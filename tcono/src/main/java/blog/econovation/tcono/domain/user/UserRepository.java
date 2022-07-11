package blog.econovation.tcono.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    List<User> findByUserName(@Param("userName") String userName);

    @Query("SELECT u FROM User u WHERE u.userEmail = :userEmail")
    List<User> findByUserEmail(String userEmail);

    User findUserByUserEmailAndPassword(String userEmail, String password);
}
