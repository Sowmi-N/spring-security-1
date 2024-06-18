package spring.boot.security_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import spring.boot.security_4.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class Security4Application {

	public static void main(String[] args) {
		SpringApplication.run(Security4Application.class, args);
	}

}
