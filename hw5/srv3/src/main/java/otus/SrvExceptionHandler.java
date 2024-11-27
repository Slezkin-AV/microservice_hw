package otus;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class SrvExceptionHandler {

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<SrvErrorResponce> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
        SrvErrorResponce apiErrorResponse = new SrvErrorResponce(404, "Resource not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(apiErrorResponse);
    }
}
