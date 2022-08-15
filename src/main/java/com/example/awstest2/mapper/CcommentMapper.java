package com.example.awstest2.mapper;

import com.example.awstest2.model.Ccomment;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CcommentMapper {


    @Select("SELECT * FROM Ccomment WHERE pno=#{pno}")
    List<Ccomment> getCcomments(@Param("pno")int pno);

    @Select("SELECT * FROM Ccomment WHERE pno=#{pno} AND cno=#{cno} AND ccno=#{ccno}")
    Ccomment getCcomment(@Param("pno")int pno,@Param("cno")int cno,@Param("ccno")int ccno);

    @Insert("INSERT INTO Ccomment (pno,cno,ccno,ccid,ccment,ccdate) VALUES (#{pno},#{cno},#{ccno},#{ccid},#{ccment},#{ccdate})")
    int postCcomment (@Param("pno")int pno,@Param("cno")int cno, @Param("ccno")int ccno, @Param("ccid")String ccid, @Param("ccment")String ccment, @Param("ccdate") Timestamp ccdate);


    @Delete("DELETE FROM Ccomment WHERE pno=#{pno} AND cno=#{cno} AND ccno=#{ccno}")
    int deleteCcomment(@Param("pno")int pno,@Param("cno") int cno,@Param("ccno") int ccno);

}
