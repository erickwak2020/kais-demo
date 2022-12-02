package gov.mois.kais.global.api.error;

import gov.mois.kais.global.api.common.ErrorResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class KaisExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponseEntity> handle404(NoHandlerFoundException ex) {
        return ErrorResponseEntity.of(HttpStatus.NOT_FOUND, ex.getMessage());
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
