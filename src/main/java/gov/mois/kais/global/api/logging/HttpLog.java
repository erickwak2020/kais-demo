package gov.mois.kais.global.api.logging;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter @Getter
@Builder
@ToString
public class HttpLog {
    private long id;
    private String traceId;
    private String httpType; // Request, Response
    private String uri;
    private String header;
    private String body;
    private LocalDateTime createdAt;
}
