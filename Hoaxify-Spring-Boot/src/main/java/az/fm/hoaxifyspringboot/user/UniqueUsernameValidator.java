package az.fm.hoaxifyspringboot.user;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    private final UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername uniqueUsername) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        User user = userRepository.findByUsername(username);
        if(user !=null){
            return false;
        }
        return true;
    }
}
