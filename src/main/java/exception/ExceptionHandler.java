package exception;

import exception.config.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ResponseEntity handleException(Exception e, Locale locale) {
        return ResponseEntity.badRequest().body("Exception accured inside API " + e);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(JavaToDevGlobalException.class)
    protected ResponseEntity handleGlobalException(JavaToDevGlobalException e, Locale locale) {
        return ResponseEntity.badRequest().body(ErrorResponse.builder().code(e.getConde()).message(e.getMessage()));
    }

}
