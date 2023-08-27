package webapplication.login_signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication(scanBasePackages = "webapplication.login_signup")
@EnableWebMvc
@ControllerAdvice
@EnableEurekaClient
public class MicroserviceLoginSignUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceLoginSignUpApplication.class, args);
    }
}

