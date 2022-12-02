package gov.mois.kais.global.api.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;

/*
{
  "timestamp": "2022-12-02T00:05:19.805+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "No message available",
  "path": "/api/member"
}
 */
@Getter
@Setter
@Builder
public class ErrorResponseEntity {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Object details;

    public static ResponseEntity<ErrorResponseEntity> of(final HttpStatus status) {
        return of(status, status.getReasonPhrase());
    }

    public static ResponseEntity<ErrorResponseEntity> of(final HttpStatus status, final String message) {
        ErrorResponseEntity errorResponseEntity = ErrorResponseEntity.builder()
                .status(status.value())
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(status).body(errorResponseEntity);
    }

    public static ResponseEntity<ErrorResponseEntity> badRequest(Object object) {
        ErrorResponseEntity errorResponseEntity = ErrorResponseEntity.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .details(object)
                .build();
        return ResponseEntity.badRequest().body(errorResponseEntity);
    }

}
