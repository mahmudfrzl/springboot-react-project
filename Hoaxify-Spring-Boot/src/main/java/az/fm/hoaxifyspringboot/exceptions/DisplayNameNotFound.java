package az.fm.hoaxifyspringboot.exceptions;

public class DisplayNameNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DisplayNameNotFound(String message) {
        super(message);
    }
}