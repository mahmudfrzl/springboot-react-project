package az.fm.hoaxifyspringboot.exceptions;

public class UsernameNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UsernameNotFound(String message) {
        super(message);
    }
}
