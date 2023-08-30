package webapplication.login_signup.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import webapplication.login_signup.Security.BCryptUserPassword.UserModelDetailsService;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserModelDetailsService userDetailsService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserModelDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Autowired


    private List<UserModel> listAllUsers() {
        return userRepository.findAll();
    }

    private UserModel getUserEmailAndPassword(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        String storedHashedPassword = userDetails.getPassword();
        boolean matchesPassword = passwordEncoder.matches(password, storedHashedPassword);

        if (!matchesPassword) {
            return null;
        }

        return userRepository.findByEmailAndPassword(email, storedHashedPassword);
    }

    private UserModel createNewUser(UserModel userModel) {
        UserModel existingEmail = userRepository.findByEmail(userModel.getEmail());

        if (existingEmail != null) {
            return null;
        }

        userModel.setEmail(HtmlUtils.htmlEscape(userModel.getEmail()));

        String hashedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(hashedPassword);

        return userRepository.save(userModel);
    }

    public List<UserModel> getAllUsers() {
        return listAllUsers();
    }

    public UserModel getUserByEmailAndPassword(String email, String password) {
        return getUserEmailAndPassword(email, password);
    }

    public UserModel createUser(UserModel userModel) {
        return createNewUser(userModel);
    }

}