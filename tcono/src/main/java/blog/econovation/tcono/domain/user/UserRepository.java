package blog.econovation.tcono.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    List<User> findByUserName(@Param("userName") String userName);
    User findByuserEmail(String userEmail);
}
