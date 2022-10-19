package com.example.awstest2.mapper;

import com.example.awstest2.model.Cafeteria;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CafeteriaMapper {
    @Insert("INSERT INTO Cafeteria (tid,cdate,ctype,content,image) VALUES (#{tid},#{cdate},#{ctype},#{content},#{image})")
    int insertCafeteria(@Param("tid") int tid, @Param("cdate") String cdate,@Param("ctype") int ctype, @Param("content") String content, @Param("image") String image);

    @Select("SELECT * FROM Cafeteria WHERE tid=#{tid} ORDER BY cdate DESC")
    List<Cafeteria> selectCafeteria(@Param("tid") int tid);
    @Delete("DELETE FROM Cafeteria WHERE tid=#{tid} AND cdate=#{cdate} AND ctype=#{ctype}")
    int deleteCafeteria(@Param("tid") int tid,  @Param("cdate")  String cdate,@Param("ctype") int ctype);
    @Update("UPDATE Cafeteria SET content=#{content}, image=#{image} WHERE tid=#{tid} AND cdate=#{cdate} AND ctype=#{ctype}" )
    int updateCafeteria(@Param("tid") int tid,  @Param("cdate")  String cdate, @Param("ctype") int ctype,  @Param("content") String content,@Param("image") String image);
}
