package com.example.awstest2.mapper;

import com.example.awstest2.model.Child;
import com.example.awstest2.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface ChildMapper {

    @Select("SELECT * FROM Child")
    List<Child> getChildProfileList();

    @Select("SELECT * FROM Child WHERE couplenum=#{couplenum} AND name=#{name}")
    Child getChildProfile(@Param("couplenum") int couplenum, @Param("name")String name);

    @Insert("INSERT INTO Child (couplenum,kname,name,sex) VALUES(#{couplenum}, #{kname}, #{name}, #{sex})")
    int insertChildProfile(@Param("couplenum") int couplenum, @Param("kname") String kname, @Param("name") String name, @Param("sex") String sex);

}
