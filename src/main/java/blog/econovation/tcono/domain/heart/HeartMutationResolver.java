package blog.econovation.tcono.domain.heart;

import blog.econovation.tcono.domain.post.Post;
import blog.econovation.tcono.web.dto.HeartRequestDto;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HeartMutationResolver implements GraphQLMutationResolver {
    private HeartQueryResolver heartQueryResolver;
    private HeartRepository heartRepository;
    private Post post;

    @Transactional
    public int updateHeartState(HeartRequestDto heartRequestDto) {
        //좋아요가 누름 -> true 반환
        boolean isHeart = heartQueryResolver.isHeartByUser(heartRequestDto);

        //좋아요 삭제
        if (isHeart) {
            heartRepository.deleteHeartByUserAndPost(heartRequestDto.getUser(), heartRequestDto.getPost());
            return post.decreaseHearts();
        } else { // 좋아요 추가
            heartRepository.save(heartRequestDto.toEntity());
            return post.increaseHearts();
        }
    }
}