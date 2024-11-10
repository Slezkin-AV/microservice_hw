package otus.srv2;


import org.springframework.web.bind.annotation.*;

@RestController
public class Srv2Controller {


    @PostMapping("/user")
    public String postUser(){
        return "POST user";
    }

    @GetMapping("/user/{userId}")
    public String getUser(){
        return "GET user";
    }

    @PutMapping("/user/{userId}")
    public String putUser(){
        return "PUT user";
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(){
        return "DELETE user";
    }

    @GetMapping("/health/")
    public String healthCheck(){
        return "OK";
    }

    @GetMapping("/")
    public String zeroPage(){
        return "It's zero page. Use '/health/' path ";
    }
}
