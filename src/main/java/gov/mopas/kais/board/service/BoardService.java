package gov.mopas.kais.board.service;

import gov.mopas.kais.board.dao.BoardMapper;
import gov.mopas.kais.board.model.Board;
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
}
