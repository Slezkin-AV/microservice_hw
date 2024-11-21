package otus.srv2.user;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface userRepository;

    @Autowired
    public UserService(UserRepositoryInterface userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(User user){
        User usr = userRepository.save(user);
        return UserMapper.mapToUserDto(usr);
    }

    @Override
    public UserDto getUser(Long userId){
        User usr = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User could not be found"));
        return UserMapper.mapToUserDto(usr);
    }

    @Override
    public UserDto updateUser(Long userId, User user){
        User usr = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User could not be found"));

        usr.setFirstName(user.getFirstName());
        usr.setLastName(user.getLastName());
        usr.setEmail(user.getEmail());

        return UserMapper.mapToUserDto(userRepository.save(usr));
    }

    @Override
    public void deleteUser(Long userId){
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User could not be found"));
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
