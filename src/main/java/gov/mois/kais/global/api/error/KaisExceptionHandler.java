package gov.mois.kais.global.api.error;

import gov.mois.kais.global.api.common.ErrorResponseEntity;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class KaisExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponseEntity> handle404(NoHandlerFoundException ex) {
        return ErrorResponseEntity.of(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseEntity> handleValidationExceptions(
            WebRequest request,
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        /*List<String> errorList = ex.getBindingResult()
                .getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());*/
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ErrorResponseEntity.badRequest(errors);
    }

    /* 업무 로직 처리 에러인 경우 사용 @service 에서 business exception을 호출 서버 로직에러 (500) */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseEntity> businessException(BusinessException ex) {
        return ErrorResponseEntity.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseEntity> handleException(Exception ex) {
        return ErrorResponseEntity.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
