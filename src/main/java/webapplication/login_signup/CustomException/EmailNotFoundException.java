package webapplication.login_signup.CustomException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import webapplication.login_signup.RestApi.UserModel;

public class EmailNotFoundException extends UsernameNotFoundException {

    public EmailNotFoundException(String msg) {
        super(msg);
    }

}
