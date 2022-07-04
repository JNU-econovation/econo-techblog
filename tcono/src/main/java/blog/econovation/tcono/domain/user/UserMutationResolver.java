package blog.econovation.tcono.domain.user;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Slf4j
@Component
@Transactional(rollbackFor = Exception.class)
public class UserMutationResolver implements GraphQLMutationResolver {
    private final UserRepository userRepository;

    /*
    * create One User Data
    * GraphQL Schema Mutation : createUser(userEmail : String!, password : String!, year : Int!, userName : String!) : User!
    * @Param userEmail : String!, password : String!, year : Int!, userName : String!
    * @return User
    *
     */
    public final createrUser(String userEmail, String password, int year, String userName){

    }

    /*
     * delete One User Data
     * GraphQL Schema Mutation : deleteUserById(userId: Int!): Boolean!
     * @Param userId
     * @return boolean
     */
    public Boolean deleteUserById(final Long userId){
        return true;
    }
    /*
     * update One User Data
     * GraphQL Schema Mutation : updateUser(userEmail : String!, password : String!, year : Int!, userName : String!) : User!
     * @Param userEmail : String!, password : String!, year : Int!, userName : String!
     * @return boolean
     */
    public User updateUser(String userEmail, String password, int year, String userName){
        return User;
    }
    /*
     * Login User Process
     * GraphQL Schema Mutation : userLogin(userEmail : String, password : String!) : Boolean!
     * @Param userEmail : String, password : String!
     * @return Boolean
     */
    public boolean userLogin(){
        return true;
    }

    /*
     * update User's Role (ex. ADMIN -> USER,  GUEST -> USER)
     * GraphQL Schema Mutation : updateUserRole(userId : Int!, role : Role!): Role!
     * @Param userId : Int!, role : Role!
     * @return enum Role
     */
    public String updateUserRole(Long userId, String Role){
        log.info("Role : " + this.Role + "-> " + Role);
        return Role;
    }
    /*
     * Auth Process : confirmEmail and make Auth process
     * GraphQL Schema Mutation : confirmEmail(token : String!) : Void!
     * @Param token : String!
     * @return vpod
     */
    public void confirmEmail(String token){
    }
}