package com.example.awstest2.controll;
import com.example.awstest2.mapper.NoticeMapper;
import com.example.awstest2.model.Notice;
import com.example.awstest2.model.Posting;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@RestController
public class NoticeController {

    private NoticeMapper mapper;

    public NoticeController(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/notice/{tid}")        //서버 인터네셔널 오류
    public int postNotice(@PathVariable("tid") int tid, @RequestParam("ntitle") String ntitle,
                          @RequestParam("ncontent") String ncontent,  @RequestParam("image") String image) {

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        Timestamp ndate = new Timestamp(System.currentTimeMillis());
        return mapper.insertNotice(tid,ndate,ntitle,ncontent,image);
    }


}
