package otus.user;

import lombok.extern.slf4j.Slf4j;
import otus.exception.SrvException;
import otus.jwt.JwtRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import otus.security.SrvPrincipalExtractor;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface userRepository;
    private final SrvPrincipalExtractor srvPrincipalExtractor;

//    @Autowired
//    public UserService(UserRepositoryInterface userRepository){
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDto registerUser(User user){
        if( user.getLogin() == null || user.getLogin().isEmpty()){throw new SrvException(UserErrorType.ERR_LOGIN_EMPTY);}
        if( user.getEmail() ==null || user.getEmail().isEmpty()){throw new SrvException(UserErrorType.ERR_EMAIL_EMPTY);}
        if( !userRepository.findByEmail(user.getEmail()).isEmpty() ){throw new SrvException(UserErrorType.ERR_EMAIL_DUBLICATE);}
        if( !userRepository.findByLogin(user.getLogin()).isEmpty() ){throw new SrvException(UserErrorType.ERR_LOGIN_DUBLICATE);}
        return UserMapper.mapToUserDto(userRepository.save(user));
    }

    @Override
    public User loginUser(JwtRequest request){
        List<User> lst = userRepository.findByLogin(request.getLogin());
        if(lst.isEmpty() ){throw new SrvException(UserErrorType.ERR_NOT_FOUND);}
        User usr = lst.get(0);
        if( usr.getPassword() != null && request.getPassword() != null){ //сравнение если оба не null
            if (!(usr.getPassword().equals(request.getPassword()))) {
                throw new SrvException(UserErrorType.ERR_INCORRECT_PASSWORD);
            }
        }
        if( !(usr.getPassword() == null || usr.getPassword().isEmpty()) //сравнение если null или пустые
           && (request.getPassword() == null) || request.getLogin().isEmpty()) {
            throw new SrvException(UserErrorType.ERR_INCORRECT_PASSWORD);
        }
        return (usr);
    }

    @Override
    public UserDto createUser(User user){
        User usr = userRepository.save(user);
        return UserMapper.mapToUserDto(userRepository.save(user));
    }

    @Override
//    @PostAuthorize("returnedObject.userId == principal.userId")
    public UserDto getUser(Long userId){
        User usr = userRepository.findById(userId).orElseThrow(() -> new SrvException(UserErrorType.ERR_NOT_FOUND));
        String loggedUser = srvPrincipalExtractor.getUser();
        log.info("Get: logged {}, login {}", loggedUser, usr.getLogin());
        return UserMapper.mapToUserDto(usr);
    }

    @Override
    public UserDto updateUser(Long userId, User user){
        if( user.getEmail() ==null || user.getEmail().isEmpty()){throw new SrvException(UserErrorType.ERR_EMAIL_EMPTY);}
        User usr = userRepository.findById(userId).orElseThrow(() -> new SrvException(UserErrorType.ERR_NOT_FOUND));

        usr.setFirstName(user.getFirstName());
        usr.setLastName(user.getLastName());
        usr.setEmail(user.getEmail());

        return UserMapper.mapToUserDto(userRepository.save(usr));
    }

    @Override
    public void deleteUser(Long userId){
        userRepository.findById(userId).orElseThrow(() -> new SrvException(UserErrorType.ERR_NOT_FOUND));
        userRepository.deleteById(userId);
        return;
    }

//    public List<UserDto> getAllUsers(){
//        List<UserDto> ls = new ArrayList<UserDto>();
//        UserDto usr = new UserDto();
//        ls.add(usr);
//        return ls;
//    }

    //    public UserDto createUser(String firstName, String secondName, String email){
//        UserDto usr = new UserDto(firstName, secondName, email);
//        return usr;
//    }

}
