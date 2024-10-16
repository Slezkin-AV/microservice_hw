package otus.srv1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Srv1Controller {

    @GetMapping("/health/")
    public String healthCheck(){
        return "OK";
    }

    @GetMapping("/")
    public String zeroPage(){
        return "It's zero page. Use '/health/' path ";
    }
}
