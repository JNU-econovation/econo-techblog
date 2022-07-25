package blog.econovation.tcono.domain.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {

    /**
     * Get User One Data
     * GraphQL Schema Query : user(userId:Long):User!
     * @param userId
     * @return
     */
}
