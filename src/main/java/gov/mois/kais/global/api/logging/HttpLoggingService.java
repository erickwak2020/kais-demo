package gov.mois.kais.global.api.logging;

import gov.mois.kais.board.dto.BoardCreateRequestDto;
import gov.mois.kais.board.model.Board;
import gov.mois.kais.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class HttpLoggingService {

    private final HttpLogMapper httpLogMapper;

    public void saveHttpRequestLog(String traceId, RequestWrapper request) throws IOException {
        String queryString = request.getQueryString();
        String uri = queryString == null ? request.getRequestURI() : request.getRequestURI() + queryString;


        byte[] content = StreamUtils.copyToByteArray(request.getInputStream());
        String contentString = new String(content);

        HttpLog httpLog = HttpLog.builder()
                .httpType("request")
                .uri(uri)
                .traceId(traceId)
                .header(request.getContentType())
                .body(contentString)
                .createdAt(LocalDateTime.now())
                .build();
        httpLogMapper.save(httpLog);
    }

    public void saveHttpResponseLog(String traceId, ContentCachingResponseWrapper response) throws IOException {
        byte[] content = StreamUtils.copyToByteArray(response.getContentInputStream());
        String contentString = new String(content);
        HttpLog httpLog = HttpLog.builder()
                .httpType("response")
                .traceId(traceId)
                .header(response.getContentType())
                .body(contentString)
                .createdAt(LocalDateTime.now())
                .build();
        httpLogMapper.save(httpLog);
     }
}
