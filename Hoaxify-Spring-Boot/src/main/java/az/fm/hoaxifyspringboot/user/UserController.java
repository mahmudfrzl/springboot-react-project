package az.fm.hoaxifyspringboot.user;

import az.fm.hoaxifyspringboot.exceptions.DisplayNameNotFound;
import az.fm.hoaxifyspringboot.exceptions.ExceptionResponse;
import az.fm.hoaxifyspringboot.exceptions.UsernameNotFound;
import az.fm.hoaxifyspringboot.exceptions.ValidationError;
import az.fm.hoaxifyspringboot.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final GenericResponse genericResponse;

    private final UserRepository userRepository;

    @PostMapping("/1.0/users")
    public GenericResponse createUser(@Valid @RequestBody User user){
        userService.save(user);
        genericResponse.setMessage("user Created");
        return genericResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleValidationException(MethodArgumentNotValidException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(400,"Validation Error","api/1.0/users");
        Map<String,String> validationErrors = new HashMap<>();
        for(FieldError fieldError:exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        exceptionResponse.setValidationErrors(validationErrors);
        return exceptionResponse;
    }
}
