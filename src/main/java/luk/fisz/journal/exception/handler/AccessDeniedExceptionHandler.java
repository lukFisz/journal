package luk.fisz.journal.exception.handler;

import luk.fisz.journal.exception.type.UserNotEntryOwnerException;
import luk.fisz.journal.exception.type.UserNotJournalOwnerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static luk.fisz.journal.common.ExceptionProperties.EXCEPTION_KEY;
import static luk.fisz.journal.common.ExceptionProperties.MESSAGE_KEY;

@RestControllerAdvice
public class AccessDeniedExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = {UserNotEntryOwnerException.class, UserNotJournalOwnerException.class})
    public Map<String, String> handleValidationExceptions(RuntimeException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(EXCEPTION_KEY, ex.getClass().getSimpleName());
        errors.put(MESSAGE_KEY, ex.getMessage());
        return errors;
    }

}
