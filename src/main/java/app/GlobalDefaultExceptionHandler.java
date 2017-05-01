package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pyt.service.PytServiceException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Object> handleException(Exception ex) {

        log.error(ex.getMessage());

        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({PytServiceException.class})
    public ResponseEntity<Object> handleExceptionPyt(Exception ex) {

        log.error(ex.getMessage());

        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
