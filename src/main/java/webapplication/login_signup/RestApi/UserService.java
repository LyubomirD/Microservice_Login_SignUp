package webapplication.login_signup.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private List<UserModel> listAllUsers() {
        return userRepository.findAll();
    }

    private UserModel getUserEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    private UserModel createNewUser(UserModel userModel) {
        UserModel existingEmail = userRepository.findByEmail(userModel.getEmail());

        if (existingEmail != null) {
            return null;
        }

        userModel.setEmail(HtmlUtils.htmlEscape(userModel.getEmail()));

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