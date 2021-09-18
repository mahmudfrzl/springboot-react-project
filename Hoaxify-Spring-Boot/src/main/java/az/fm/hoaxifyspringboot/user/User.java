package az.fm.hoaxifyspringboot.user;

import lombok.Data;
import lombok.ToString;

@Data
public class User {
    private String username;
    private String displayName;
    private String password;
}
