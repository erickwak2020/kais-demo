package gov.mois.kais.board.dao;

import gov.mois.kais.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> findAll();

    int save(Board board);

    Board findById(Long id);
}
