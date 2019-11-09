package cn.cnm.mapper;

import cn.cnm.pojo.Airport;
import cn.cnm.pojo.AirportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirportMapper {
    long countByExample(AirportExample example);

    int deleteByExample(AirportExample example);

    int insert(Airport record);

    int insertSelective(Airport record);

    List<Airport> selectByExample(AirportExample example);

    int updateByExampleSelective(@Param("record") Airport record, @Param("example") AirportExample example);

    int updateByExample(@Param("record") Airport record, @Param("example") AirportExample example);
}