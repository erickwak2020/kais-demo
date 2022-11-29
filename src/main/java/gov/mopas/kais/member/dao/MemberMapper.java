package gov.mopas.kais.member.dao;

import gov.mopas.kais.member.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<Member> findAll();

    void save(Member member);

}
