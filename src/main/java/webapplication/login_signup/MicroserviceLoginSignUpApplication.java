package webapplication.login_signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication(scanBasePackages = "webapplication.login_signup.RestApi")
@EnableWebMvc
@ControllerAdvice
public class MicroserviceLoginSignUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceLoginSignUpApplication.class, args);
    }
}

