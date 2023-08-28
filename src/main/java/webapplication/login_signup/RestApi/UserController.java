package webapplication.login_signup.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usersRegistration")
@CrossOrigin(origins = "http://localhost:5000")
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get")
    public ResponseEntity<UserModel> getUser(@Valid @RequestBody UserModel userModel) {
        String email = userModel.getEmail();
        String password = userModel.getPassword();

        UserModel searchedUser = userService.getUserByEmailAndPassword(email, password);
        if (searchedUser != null) {
            return ResponseEntity.ok(searchedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel userModel, BindingResult bindingResult) {
        UserModel createdUser = userService.createUser(userModel);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(createdUser);
        }
        if (createdUser == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}
