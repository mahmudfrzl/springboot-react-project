package az.fm.hoaxifyspringboot.exceptions;

public class ValidationError extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ValidationError(String message) {
        super(message);
    }


}
