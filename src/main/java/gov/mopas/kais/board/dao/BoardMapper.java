package gov.mopas.kais.board.dao;

import gov.mopas.kais.board.model.Board;
import gov.mopas.kais.member.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> findAll();

    void save(Board board);

    Board findById(Long id);
}
