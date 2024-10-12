package otus.srv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Srv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Srv1Application.class, args);
	}

}
