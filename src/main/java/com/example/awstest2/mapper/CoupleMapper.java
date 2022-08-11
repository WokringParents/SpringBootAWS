package com.example.awstest2.mapper;

import com.example.awstest2.model.Couple;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

@Mapper
public interface CoupleMapper {


    @Select("SELECT * FROM Couple WHERE mid=#{id} OR did=#{id}")
    Couple selectCouple(@Param("id")String id);

    @Insert("INSERT INTO Couple (mid,did) VALUES (#{mid},#{did})")
    int insertCouple(@Param("mid")String mid, @Param("did") String did);

    @Insert("INSERT INTO Couple (city,village) VALUES (#{city},#{village})")
    int insertAddress(@Param("city")String city, @Param("village") String village);


}
