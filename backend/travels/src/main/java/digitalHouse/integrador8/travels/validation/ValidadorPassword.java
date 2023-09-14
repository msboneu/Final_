package digitalHouse.integrador8.travels.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;

public class ValidadorPassword implements ConstraintValidator<PasswordValido, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator passwordValidator = new PasswordValidator(
                Arrays.asList(
                        // Entre 8 y 20 caracteres
                        new LengthRule(8, 20),
                        // Al menos una mayuscula
                        new CharacterRule(EnglishCharacterData.UpperCase, 1),
                        // Al menos una minuscula
                        new CharacterRule(EnglishCharacterData.LowerCase, 2),
                        // Al menos un número
                        new CharacterRule(EnglishCharacterData.Digit, 1),
                        // Al menos un caracter especial
                        new CharacterRule(EnglishCharacterData.Special, 1)
                )
        );
        RuleResult result = passwordValidator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        } else {
            constraintValidatorContext.buildConstraintViolationWithTemplate(passwordValidator.getMessages(result).stream().findFirst().get())
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();

            return false;
        }
    }
}
