package webapplication.login_signup.CustomAnnotations;

import org.apache.commons.text.StringEscapeUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PreventXSS implements ConstraintValidator<PreventXSSAttacks, String> {

    @Override
    public void initialize(PreventXSSAttacks constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (containsHarmfulContent(value)) {
            return false;
        }

        return true;
    }

    private boolean containsHarmfulContent(String input) {
        String sanitizedInput = StringEscapeUtils.escapeHtml4(input);

        return !input.equals(sanitizedInput) || input.contains("&");
    }
}
