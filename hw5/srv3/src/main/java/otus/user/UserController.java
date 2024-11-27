package otus.user;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
//@RequestMapping("api/users")
public class UserController {

    private UserService userService;// = new UserService();

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    // build create User REST API
    @Timed("create_user")
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/user/{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody User user){
//        user.setId(userId);
        UserDto updatedUser = userService.updateUser(userId,user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/health/")
    public String healthCheck(){
        return "OK";
    }

    @GetMapping("/")
    public String zeroPage(){
        return "It's zero page. Use '/health/' path ";
    }
    //    // Build Get All Users REST API
//    // http://localhost:8080/api/users
//    @GetMapping("/users")
//    public ResponseEntity<List<UserDto>> getAllUsers(){
//        List<UserDto> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
}