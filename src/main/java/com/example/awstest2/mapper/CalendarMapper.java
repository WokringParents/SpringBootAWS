package com.example.awstest2.mapper;


import com.example.awstest2.model.Calendar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CalendarMapper {

    @Select("SELECT * FROM Calendar WHERE couplenum= #{couplenum}")
    List<Calendar> getCalendar(@Param("couplenum") int couplenum);

    @Insert("INSERT INTO Calendar(couplenum,cdate,ctitle,ccontent,csex) VALUES(#{couplenum}, #{cdate}, #{ctitle}, #{ccontent}, #{csex})")
    int insertCalendar(@Param("couplenum") int couplenum, @Param("cdate") String cdate, @Param("ctitle") String ctitle, @Param("ccontent") String ccontent, @Param("csex") String csex);



}
