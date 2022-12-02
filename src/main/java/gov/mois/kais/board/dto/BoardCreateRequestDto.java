package gov.mois.kais.board.dto;

import gov.mois.kais.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class BoardCreateRequestDto {

    @Schema(description = "게시물 제목")
    @NotBlank(message = "Name is mandatory")
    private String title;

    @Schema(description = "게시물 내용")
    @NotBlank
    private String content;

    public Board toModel() {
        return Board.builder()
                .title(title).content(content)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
