package app;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    Logger log = Logger.getLogger(this.getClass());

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Object> handleException(Exception ex) {

        log.error(ex.getMessage());

        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
    }
}