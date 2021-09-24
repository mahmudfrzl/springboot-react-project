package az.fm.hoaxifyspringboot.user;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    @PostMapping("/1.0/users")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }
}
