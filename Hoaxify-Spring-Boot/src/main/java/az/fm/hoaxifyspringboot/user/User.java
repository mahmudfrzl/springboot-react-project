package az.fm.hoaxifyspringboot.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull(message = "{hoaxify.constraint.username.NotNull.message}")
    @Size(min = 4,max = 255)
    @UniqueUsername
    @Column(name = "username",nullable = false)
    private String username;
    @NotNull
    @Size(min = 4,max = 255)
    @Column(name = "display_name",nullable = false)
    private String displayName;
    @NotNull(message = "{hoaxify.constraint.password.Patter.message}")
    @Size(min = 6)
    @Column(name = "password",nullable = false)
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*[a-z])(?=.*\\d).*$")
    private String password;
}
