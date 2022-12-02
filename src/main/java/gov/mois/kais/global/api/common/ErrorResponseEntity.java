package gov.mois.kais.global.api.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

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

    public static ResponseEntity<ErrorResponseEntity> of(final HttpStatus status){
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

}
