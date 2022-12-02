package gov.mois.kais.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter
@Builder
@ToString
public class Board {

    @Schema(description = "게시물 아이디")
    private Long id;

    @Schema(description = "게시물 제목")
    @NotBlank(message = "Name is mandatory")
    private String title;

    @Schema(description = "게시물 내용")
    @Size(min=10)
    private String content;

    @Schema(description = "게시물 생성 일자")
    private LocalDateTime createdAt;

}
