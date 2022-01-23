package br.com.udemy.Spring.FullStack.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest){
        String error = "Object Not Found Exception";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, resourceNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> exceptionErrorDefault(DataIntegrityViolationException dataIntegrityViolationException, HttpServletRequest httpServletRequest) {
        String error = "Error Constraint Violation";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, dataIntegrityViolationException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> exceptionErrorDefault(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest) {
        String errorMessage = "Error Validation";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ValidationError validationError = new ValidationError(Instant.now(), httpStatus.value(), errorMessage,
                "ERROR VALIDATION", httpServletRequest.getRequestURI());
        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationError.addListFieldMessage(error.getField(),error.getDefaultMessage());
        }
        return ResponseEntity.status(httpStatus).body(validationError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> exceptionErrorDefault(Exception exception, HttpServletRequest httpServletRequest) {
       String error = "Exception Error Default";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }
}
