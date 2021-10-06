package az.fm.hoaxifyspringboot.auth;

import az.fm.hoaxifyspringboot.exceptions.ExceptionResponse;
import az.fm.hoaxifyspringboot.user.User;
import az.fm.hoaxifyspringboot.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class AuthController {
    @Autowired
    private  UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/api/1.0/auth")
    ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization",required = false) String authorization){
        if(authorization == null){
            ExceptionResponse exceptionResponse = new ExceptionResponse(401,"Unauthorized request","/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionResponse);
        }
        String base64Coded = authorization.split("Basic ")[1];
        String decoded = new String(Base64.getDecoder().decode(base64Coded));
        String[] parts =decoded.split(":");
        String username = parts[0];
        User inDb  = userRepository.findByUsername(username);
        if(inDb == null){
            ExceptionResponse exceptionResponse = new ExceptionResponse(401,"Unauthorized request","/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionResponse);
        }
        log.info(authorization);
        return ResponseEntity.ok().build();
    }
}
