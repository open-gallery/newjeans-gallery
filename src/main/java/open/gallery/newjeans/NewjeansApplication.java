package open.gallery.newjeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NewjeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewjeansApplication.class, args);
	}

}
