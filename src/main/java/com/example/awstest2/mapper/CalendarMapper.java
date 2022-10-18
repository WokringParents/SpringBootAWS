package com.example.awstest2.mapper;


import com.example.awstest2.model.Calendar;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CalendarMapper {

    @Select("SELECT * FROM Calendar WHERE couplenum= #{couplenum}")
    List<Calendar> getCalendar(@Param("couplenum") int couplenum);

    @Insert("INSERT INTO Calendar(couplenum,cdate,startTime, endTime ,ccontent,csex) VALUES(#{couplenum}, #{cdate}, #{startTime} ,#{endTime}, #{ccontent}, #{csex})")
    int insertCalendar(@Param("couplenum") int couplenum, @Param("cdate") String cdate, @Param("startTime") String startTime,
                    @Param("endTime") String endTime, @Param("ccontent") String ccontent, @Param("csex") String csex);

    @Update("UPDATE Calendar SET startTime=#{startTime}, endTime=#{endTime}, ccontent= #{ccontent}  WHERE couplenum =#{couplenum} AND cdate= #{cdate}")
    int putCalendar(@Param("couplenum")int couplenum, @Param("cdate")String cdate,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("ccontent")String ccontent);


    @Delete("DELETE FROM Calendar WHERE couplenum =#{couplenum} AND cdate= #{cdate}")
    int deleteCalendar(@Param("couplenum")int couplenum, @Param("cdate")String cdate);

}
