package az.fm.hoaxifyspringboot.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    private int status;

    private String message;

    private String path;

    private long timeStamp = new Date().getTime();

    private Map<String,String> validationErrors;

    public ExceptionResponse(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
