package com.example.awstest2.mapper;

import com.example.awstest2.model.Image;
import com.example.awstest2.model.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ImageMapper {


    @Select("SELECT * FROM Image WHERE nid=#{nid}")
    List<Image> getImagebynid(@Param("nid")int nid);

    @Insert("INSERT INTO Image VALUES (#{image},#{nid})")
    int insertImage(@Param("image")String image,@Param("nid")int nid);

}
