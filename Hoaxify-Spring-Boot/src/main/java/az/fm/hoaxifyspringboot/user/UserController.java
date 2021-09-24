package az.fm.hoaxifyspringboot.user;

import az.fm.hoaxifyspringboot.exceptions.ExceptionResponse;
import az.fm.hoaxifyspringboot.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createUser(@RequestBody User user){
        ExceptionResponse exceptionResponse = new ExceptionResponse(400,"Validation Error","api/1.0/users");
        Map<String,String> validationErrors = new HashMap<>();
        String username = user.getUsername();
        String displayName = user.getDisplayName();
        if(username==null || username.isEmpty()){
            validationErrors.put("username","Username cannot be null!");
        }
        if(displayName==null || displayName.isEmpty()){
            validationErrors.put("displayName","Cannot be null");
        }
        if(validationErrors.size()>0){
            exceptionResponse.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
        }
        userService.save(user);
        genericResponse.setMessage("user Created");
        return ResponseEntity.ok(genericResponse);
    }
}
