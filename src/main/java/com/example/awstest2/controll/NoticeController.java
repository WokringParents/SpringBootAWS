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

    @PostMapping("/notice/{tid}")
    public Notice postNotice(@PathVariable("tid") int tid, @RequestParam("ntitle") String ntitle,
                          @RequestParam("ncontent") String ncontent,  @RequestParam("image") String image) {

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        String ndate = new Timestamp(System.currentTimeMillis()).toString();
        ndate=ndate.substring(0,ndate.length()-4);
        mapper.insertNotice(tid,ndate,ntitle,ncontent,image);
        return mapper.getNoticeId(tid,ndate,ncontent);
    }

    @GetMapping("/notice/nid")
    public Notice getNoticebyContent(@RequestParam("tid") int tid, @RequestParam("ndate") String ndate,
                                  @RequestParam("ncontent") String ncontent) {
        return mapper.getNoticeId(tid,ndate,ncontent);
    }


}
