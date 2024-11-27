package otus.user;

public interface UserServiceInterface {
    UserDto createUser(User user);
    UserDto getUser(Long id);
    UserDto updateUser(Long ig, User user);
    void deleteUser(Long id);
}
