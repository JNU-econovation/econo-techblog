package blog.econovation.tcono.domain.heart;

import blog.econovation.tcono.domain.user.UserRepository;
import blog.econovation.tcono.web.dto.HeartRequestDto;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HeartQueryResolver implements GraphQLQueryResolver {
    private static final String NOT_FOUND_USER_MESSAGE = "존재하지 않은 회원입니다.";
    private HeartRepository heartRepository;
    private UserRepository userRepository;

    /**
     * 특정 User가 Post에 좋아요를 누름 -> true 반환
     *
     * @param heartAddRequestDto(Long heartId,User user,Post post)
     * @return boolean
     */
    @Transactional
    public boolean isHeartByUser(HeartRequestDto heartAddRequestDto) {
        // 존재하는 User인지 조사
        userRepository.findByuserEmail(heartAddRequestDto.getUserEmail())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));

        //해당 User가 heart를 눌렀는지 조사
        Optional<Heart> findHeart = heartRepository.findHeartByUserAndPost(heartAddRequestDto.getUser(), heartAddRequestDto.getPost());

        return findHeart.isPresent();
    }

}
