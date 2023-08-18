package webapplication.login_signup.CustomException;

import javax.validation.ConstraintViolationException;

public class ValidationException extends ConstraintViolationException {

    public ValidationException(String message) {
        super(message, null);
    }
}
