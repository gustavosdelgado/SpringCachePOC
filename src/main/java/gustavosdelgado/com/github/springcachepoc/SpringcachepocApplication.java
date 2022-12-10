package gustavosdelgado.com.github.springcachepoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringcachepocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcachepocApplication.class, args);
	}

}