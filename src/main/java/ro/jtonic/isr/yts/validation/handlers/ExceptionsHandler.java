package ro.jtonic.isr.yts.validation.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.jtonic.isr.yts.validation.model.ErrorMessage;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * Created by Antonel Ernest Pazargic on 09/05/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(ConstraintViolationException ex) {
        final String errDescription = ex.getConstraintViolations()
                                 .stream()
                                 .map(ConstraintViolation::getMessage)
                                 .collect(Collectors.joining(","));
        final ErrorMessage errorMessage = ErrorMessage.builder()
                                               .message("Invalid value")
                                               .description(errDescription)
                                               .build();
        return ResponseEntity.badRequest().body(errorMessage);
    }

}
