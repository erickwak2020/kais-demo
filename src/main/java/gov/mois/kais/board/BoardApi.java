package gov.mois.kais.board;

import gov.mois.kais.board.model.Board;
import gov.mois.kais.board.service.BoardService;
import gov.mois.kais.global.api.common.BaseResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "게시물", description = "게시물 관련 api 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardApi {

    private final BoardService boardService;

    @Operation(summary = "게시물 목록 메서드", description = "게시물 목록 메서드입니다.")
    @GetMapping("")
    public ResponseEntity<BaseResponseEntity<List<Board>>> getBoards() {
        return BaseResponseEntity.ok(boardService.getBoards());
    }

    @Operation(summary = "게시물 조회 메서드", description = "게시물 조회 메서드입니다.")
    @Parameter(name = "id", description = "posts 의 id", in = ParameterIn.PATH)
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseEntity<Board>> getBoard(@PathVariable Long id) {
        return BaseResponseEntity.ok(boardService.getBoard(id));
    }

    @GetMapping("/error")
    public ResponseEntity<Object> errorTest() {
        boardService.errorTest();
        return ResponseEntity.ok(null);
    }
}
