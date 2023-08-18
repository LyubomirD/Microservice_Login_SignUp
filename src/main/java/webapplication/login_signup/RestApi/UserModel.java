package webapplication.login_signup.RestApi;

import lombok.Getter;
import lombok.Setter;
import webapplication.login_signup.CustomAnnotations.PreventXSSAttacks;
import webapplication.login_signup.CustomAnnotations.ValidEmailFormat;
import webapplication.login_signup.CustomAnnotations.ValidPasswordFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "user_registration")
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private UUID userId;

    @NotNull
    @PreventXSSAttacks
    @Column(name = "username")
    private String username;

    @NotNull
    @ValidEmailFormat
    @PreventXSSAttacks
    @Column(name = "email")
    private String email;

    @NotNull
    @ValidPasswordFormat
    @PreventXSSAttacks
    @Column(name = "password")
    private String password;

    public UserModel() {

    }
    public UserModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
