package com.example.awstest2.mapper;
import com.example.awstest2.model.Notice;
import com.example.awstest2.model.Posting;
import org.apache.ibatis.annotations.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("SELECT * FROM Notice ORDER BY ndate DESC")
    List<Notice> getNotice();

    @Select("SELECT * FROM Notice WHERE tid=#{tid} AND ndate=#{ndate} AND ncontent=#{ncontent}")
    Notice getNoticeId(@Param("tid")int tid, @Param("ndate") String ndate, @Param("ncontent") String ncontent);

    @Insert("INSERT INTO Notice (tid,ndate,ntitle,ncontent,image) VALUES (#{tid},#{ndate},#{ntitle},#{ncontent},#{image})")
    int insertNotice(@Param("tid")int tid,@Param("ndate") String ndate,@Param("ntitle") String ntitle ,@Param("ncontent") String ncontent, @Param("image")String image);

}
