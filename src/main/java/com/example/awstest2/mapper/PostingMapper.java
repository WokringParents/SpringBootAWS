package com.example.awstest2.mapper;

import com.example.awstest2.model.Posting;
import org.apache.ibatis.annotations.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PostingMapper {

    @Select("SELECT * FROM Posting WHERE pid=#{pid} AND pdate=#{pdate} AND content=#{content}")
    Posting getBoardPostingbyPno(@Param("pid")String pid, @Param("pdate") String pdate, @Param("content") String content);

    @Select("SELECT * FROM Posting ORDER BY pdate DESC")
    List<Posting> getBoardPosting();

    @Select("SELECT * FROM Posting ORDER BY hcnt DESC")
    List<Posting> getBoardOffsetbyHcnt();

    @Select("SELECT * FROM Posting ORDER BY ccnt DESC")
    List<Posting> getBoardOffsetbyCcnt();

    //@Select("SELECT * FROM Posting ORDER BY pdate DESC LIMIT #{offset},10")
    //List<Posting> getBoardOffsetbyDate(@Param("offset")int offset);


    @Select("SELECT * FROM Posting WHERE content LIKE CONCAT('%',#{content},'%')")
    List<Posting> getPostingbyContent(@Param("content")String content);


    @Insert("INSERT INTO Posting (pid,village,goback,pdate,content) VALUES (#{pid},#{village},#{goback},#{pdate},#{content})")
    int insertBoardPosting(@Param("pid")String pid,@Param("village") String village,@Param("goback") String goback ,@Param("pdate") String pdate, @Param("content")String content);


    @Update("UPDATE Posting SET hcnt = hcnt+1 WHERE pno=#{pno}")
    int updateHcntPlus(@Param("pno")int pno);


    @Update("UPDATE Posting SET hcnt = hcnt-1 WHERE pno=#{pno}")
    int updateHcntMinus(@Param("pno")int pno);


    @Update("UPDATE Posting SET ccnt = ccnt+1 WHERE pno=#{pno}")
    int updateCcntPlus(@Param("pno")int pno);


    @Update("UPDATE Posting SET ccnt = ccnt-1 WHERE pno=#{pno}")
    int updateCcntMinus(@Param("pno")int pno);


    @Delete("DELETE FROM Posting WHERE pno=#{pno}")
    int deleteBoardPosting(@Param("pno")int pno);

}
