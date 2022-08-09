package com.example.awstest2.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

@Mapper
public interface CoupleMapper {

    @Insert("INSERT INTO Couple (mid,did) VALUES (#{mid},#{did})")
    int insertCouple(@Param("mid")String mid, @Param("did") String did);

}
