package blog.econovation.tcono.user;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

public class authServiceTest {

    @InjectMocks
    ConfirmationTokenMutationResolver ConfirmationTokenMutationResolver;

    @InjectMocks
    ConfirmationTokenQueryResolver ConfirmationTokenQueryResolver;


    @Mock
    UserRepository userRepository;


}
