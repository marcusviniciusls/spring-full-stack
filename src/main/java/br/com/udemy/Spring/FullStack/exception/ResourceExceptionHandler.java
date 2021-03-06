package br.com.udemy.Spring.FullStack.exception;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * Classe que controla todas as excessões que API poderá emitir
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    /**
     * Método que captura a excessão do tipo Resource Not Found Exception
     * Quando um método tenta buscar um registro no Banco de dado e não encontra, é emitido essa excessão.
     * @param resourceNotFoundException - Excessão capturada
     * @param httpServletRequest - Requisição capturada
     * @return - Resposta para o Controller
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest){
        String error = "OBJECT NOT FOUND EXCEPTION";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, resourceNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    /**
     * Método que captura a excessão de dataIntegrityViolationException
     * Essa excessão é lançada quando a API tenta excluir um registro, mas tem vínculo com outra tabela
     * @param dataIntegrityViolationException - Excessão capturada
     * @param httpServletRequest - Requisição capturada
     * @return - Resposta para o Controller
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> exceptionErrorDefault(DataIntegrityViolationException dataIntegrityViolationException, HttpServletRequest httpServletRequest) {
        String error = "ERROR CONSTRAINT VIOLATION";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, dataIntegrityViolationException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    /**
     * Método que captura a excessão de methodArgumentNotValidException
     * Essa excessão é lançada quando alguma regra do Java Bean Validation é violada
     * @param methodArgumentNotValidException - Excessão capturada
     * @param httpServletRequest - Requisição capturada
     * @return - Resposta para o Controller
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> exceptionErrorDefault(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest) {
        String errorMessage = "ERROR VALIDATION";
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError validationError = new ValidationError(Instant.now(), httpStatus.value(), errorMessage,
                "ERROR VALIDATION", httpServletRequest.getRequestURI());
        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationError.addListFieldMessage(error.getField(),error.getDefaultMessage());
        }
        return ResponseEntity.status(httpStatus).body(validationError);
    }

    /**
     * Método que captura a excessão de exception
     * Essa excessão é lançada quando não tratada nessa classe
     * @param exception - Excessão capturada
     * @param httpServletRequest - Requisição capturada
     * @return - Resposta para o Controller
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> exceptionErrorDefault(Exception exception, HttpServletRequest httpServletRequest) {
       String error = "Exception Error Default";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorization(AuthorizationException authorizationException, HttpServletRequest httpServletRequest){
        String error = "OBJECT NOT FOUND EXCEPTION";
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, authorizationException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(FileException.class)
    public ResponseEntity<StandardError> fileException(FileException fileException, HttpServletRequest httpServletRequest){
        String error = "Error File Excpetion";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, fileException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(AmazonServiceException.class)
    public ResponseEntity<StandardError> amazonServerException(AmazonServiceException amazonServiceException, HttpServletRequest httpServletRequest){
        String error = "Amazon Service Excpetion";
        HttpStatus httpStatus = HttpStatus.valueOf(amazonServiceException.getErrorCode());
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, amazonServiceException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(AmazonClientException.class)
    public ResponseEntity<StandardError> amazonClientException(AmazonClientException amazonClientException, HttpServletRequest httpServletRequest){
        String error = "Amazon Client Excpetion";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, amazonClientException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(AmazonS3Exception.class)
    public ResponseEntity<StandardError> amazonS3Exception(AmazonS3Exception amazonS3Exception, HttpServletRequest httpServletRequest){
        String error = "Amazon S3 Excpetion";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), httpStatus.value(), error, amazonS3Exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(erro);
    }
}
