package luk.fisz.journal.exception.handler;

import luk.fisz.journal.exception.UserNotEntryOwnerException;
import luk.fisz.journal.exception.UserNotJournalOwnerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AccessDeniedExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = {UserNotEntryOwnerException.class, UserNotJournalOwnerException.class, RuntimeException.class})
    public Map<String, String> handleValidationExceptions(RuntimeException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("exception", ex.getClass().getSimpleName());
        errors.put("message", ex.getMessage());
        return errors;
    }


}
