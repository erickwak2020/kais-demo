package gov.mois.kais.global.api.logging;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HttpLogMapper {

    void save(HttpLog httpLog);
}
