package com.example.awstest2.mapper;

import com.example.awstest2.model.Comment;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CommentMapper {


    @Select("SELECT * FROM Comment WHERE pno=#{pno}")
    List<Comment> getComments(@Param("pno")int pno);


    @Select("SELECT * FROM Comment WHERE pno=#{pno} AND cno=#{cno}")
    Comment getComment (@Param("pno")int pno, @Param("cno")int cno);

    @Insert("INSERT INTO Comment (pno,cno,cid,cment,cdate) VALUES (#{pno},#{cno},#{cid},#{cment},#{cdate})")
    int postComment(@Param("pno")int pno, @Param("cno")int cno, @Param("cid")String cid, @Param("cment")String cment,@Param("cdate") Timestamp cdate);


    @Update("UPDATE Comment SET cccnt= cccnt+1 WHERE pno=#{pno} AND cno=#{cno}")
    int updateCccntPlus(@Param("pno")int pno, @Param("cno")int cno);


    @Update("UPDATE Comment SET cccnt= cccnt-1 WHERE pno=#{pno} AND cno=#{cno}")
    int updateCccntMinus(@Param("pno")int pno, @Param("cno")int cno);


    @Delete("DELETE FROM Comment WHERE pno=#{pno} AND cno=#{cno}")
    int deleteComment(@Param("pno")int pno,  @Param("cno")int cno);




}
