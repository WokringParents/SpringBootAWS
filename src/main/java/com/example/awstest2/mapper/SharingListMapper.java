package com.example.awstest2.mapper;

import com.example.awstest2.model.SharingList;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SharingListMapper {

//성공해서 기뻤다 새벽 6시24분에 광광 울었다고 한다. 현재 타임스탬프는 동일하지만 원하는 일자까지 날만 하루씩 더해서 만든 날짜정보를 포함하여 sharingList에 다중행을 인서트 하는 쿼리문이다.
    @Insert("INSERT INTO SharingList(couplenum,sdate,content,daily) SELECT  #{couplenum}, DATE_FORMAT(DATE_ADD(#{sdate}, INTERVAL seq - 1 DAY), '%Y-%m-%d %T') AS date , #{content},1 FROM (SELECT @num := @num + 1 AS seq FROM information_schema.tables a, information_schema.tables b, (SELECT @num := 0) c) T WHERE seq <=  DATEDIFF(#{enddate}, #{startdate}) + 1")
    int insertDailyList(@Param("couplenum") int couplenum, @Param("sdate") String sdate,@Param("content")String content,@Param("enddate") String enddate,@Param("startdate")String startdate);

    @Insert("INSERT INTO SharingList(couplenum, sdate, content, daily) VALUES (#{couplenum},#{sdate},#{content},0)")
    int insertTodayList(@Param("couplenum") int couplenum, @Param("sdate") String sdate, @Param("content")String content);

    @Update("UPDATE SharingList SET mdo= 1 WHERE couplenum=#{couplenum} AND sdate=#{sdate}")
    int updateMaleDo(@Param("couplenum")int couplenum, @Param("sdate")String sdate);

    @Update("UPDATE SharingList SET fdo= 1 WHERE couplenum=#{couplenum} AND sdate=#{sdate}")
    int updateFemaleDo(@Param("couplenum")int couplenum, @Param("sdate")String sdate);

    @Select("SELECT *, WEEKDAY(sdate) FROM SharingList WHERE couplenum=#{couplenum} AND sdate BETWEEN #{startdate} AND #{enddate}")
    List<SharingList> selectSharingList(@Param("couplenum")int couplenum, @Param("startdate") Timestamp startdate, @Param("enddate")Timestamp enddate);
}
