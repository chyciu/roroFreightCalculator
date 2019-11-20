package pl.calculator.roro.roro_calculator.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.calculator.roro.roro_calculator.dto.ErrorDTO;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    private ErrorDTO handleExeption (Exception exception) {
        log.error("Exception handled", exception);
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setExceptionClass(exception.getClass().getCanonicalName());
        errorDTO.setMessage(exception.getMessage());
        return errorDTO;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorDTO handleNotFountException (EntityNotFoundException exception) {
        return handleExeption(exception) ;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ErrorDTO handleValidationException (Exception exception) {
        return handleExeption(exception);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ErrorDTO handleGeneralException (Exception exception) {
        return handleExeption(exception);
    }

}
