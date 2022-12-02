package gov.mois.kais.board.service;

import gov.mois.kais.board.dao.BoardMapper;
import gov.mois.kais.board.model.Board;
import gov.mois.kais.global.api.error.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardMapper boardMapper;

    public List<Board> getBoards() {
        return boardMapper.findAll();
    }

    public Board getBoard(Long id) {
        return boardMapper.findById(id);
    }

    public void errorTest() {
        throw new BusinessException("error test parameter is required");
    }
}
