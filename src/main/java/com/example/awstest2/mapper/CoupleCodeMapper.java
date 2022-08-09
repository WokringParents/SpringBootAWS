package com.example.awstest2.mapper;
import com.example.awstest2.model.CoupleCode;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface CoupleCodeMapper {

    @Insert("INSERT INTO CoupleCode (code,ctime,cid) VALUES (#{code},#{ctime},#{cid})")
    int insertCoupleCode(@Param("code") String code, @Param("ctime") Timestamp ctime, @Param("cid") String cid);

    @Select("SELECT cid FROM CoupleCode WHERE code=#{code}")
    String selectCID(@Param("code") String code);
    @Delete("DELETE FROM CoupleCode WHERE code=#{code}")
    int deleteCoupleCode(@Param("code") String code);
}
