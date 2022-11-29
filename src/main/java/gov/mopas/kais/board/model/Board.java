package gov.mopas.kais.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Board {

    @Schema(description = "게시물 아이디")
    private Long id;

    @Schema(description = "게시물 제목")
    private String title;

    @Schema(description = "게시물 내용")
    private String content;

    @Schema(description = "게시물 생성 일자")
    private LocalDateTime createdAt;

}
