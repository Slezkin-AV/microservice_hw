package otus.srv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Srv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Srv2Application.class, args);
	}

}
