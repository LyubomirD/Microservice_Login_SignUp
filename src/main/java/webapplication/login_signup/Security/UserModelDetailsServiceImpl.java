package webapplication.login_signup.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import webapplication.login_signup.RestApi.UserModel;
import webapplication.login_signup.RestApi.UserRepository;

import java.util.ArrayList;

@Service
public class UserModelDetailsServiceImpl implements UserModelDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Retrieve user data from your database
        UserModel user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Construct UserDetails object based on retrieved data
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>() // You might need to populate roles and authorities here
        );
    }
}
