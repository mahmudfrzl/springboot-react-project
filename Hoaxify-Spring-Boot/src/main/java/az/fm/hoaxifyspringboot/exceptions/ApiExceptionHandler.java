package az.fm.hoaxifyspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UsernameNotFound.class)
    private final ResponseEntity<ExceptionResponse> usernameNotFoundException(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(400,exception.getMessage(),"api/1.0/users");
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DisplayNameNotFound.class)
    private final ResponseEntity<ExceptionResponse> displayNameNotFoundException(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(400,exception.getMessage(),"api/1.0/users");
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ValidationError.class)
    private final ResponseEntity<ExceptionResponse> validationError(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(400,exception.getMessage(),"api/1.0/users");
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
