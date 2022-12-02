package gov.mois.kais.global.api.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class BaseResponseEntity<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private T results;


    public static<T> ResponseEntity<BaseResponseEntity<T>> ofMessage(final String responseMessage) {
        return ok(HttpStatus.OK, responseMessage, null);
    }

    public static<T> ResponseEntity<BaseResponseEntity<T>> ofMessage(final String responseMessage, final T t) {
        return ok(HttpStatus.OK, responseMessage, null);
    }

    public static<T> ResponseEntity<BaseResponseEntity<T>> ok(final T t) {
        return ok(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), t);
    }

    public static<T> ResponseEntity<BaseResponseEntity<T>> ok(final HttpStatus statusCode, final String responseMessage, final T t) {
        BaseResponseEntity<T> baseResponse = BaseResponseEntity.<T>builder()
                .results(t)
                .status(HttpStatus.OK.value())
                .message(responseMessage)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(baseResponse);
    }
}
