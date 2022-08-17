package com.example.awstest2.mapper;

import com.example.awstest2.model.SharingList;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SharingListMapper {

    @Insert("INSERT INTO SharingList(couplenum, sdate, content, daily) VALUES (#{couplenum},#{sdate},#{content},#{daily})")
    int insertSharingList(@Param("couplenum") int couplenum, @Param("sdate") Timestamp sdate, @Param("content")String content, @Param("daily")Boolean daily);

    @Update("UPDATE SharingList SET mdo= 1 WHERE couplenum=#{couplenum} AND sdate=#{sdate}")
    int updateMaleDo(@Param("couplenum")int couplenum, @Param("sdate")Timestamp sdate);

    @Update("UPDATE SharingList SET fdo= 1 WHERE couplenum=#{couplenum} AND sdate=#{sdate}")
    int updateFemaleDo(@Param("couplenum")int couplenum, @Param("sdate")Timestamp sdate);

    @Select("SELECT *, WEEKDAY(sdate) FROM SharingList WHERE couplenum=#{couplenum} AND sdate BETWEEN #{startdate} AND #{enddate}")
    List<SharingList> selectSharingList(@Param("couplenum")int couplenum, @Param("startdate") Timestamp startdate, @Param("enddate")Timestamp enddate);
}
