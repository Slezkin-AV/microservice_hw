package otus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrvApplication.class, args);
	}

}
