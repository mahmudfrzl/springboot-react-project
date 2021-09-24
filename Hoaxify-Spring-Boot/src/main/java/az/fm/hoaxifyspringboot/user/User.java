package az.fm.hoaxifyspringboot.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "display_name",nullable = false)
    private String displayName;
    @Column(name = "password",nullable = false)
    private String password;
}
