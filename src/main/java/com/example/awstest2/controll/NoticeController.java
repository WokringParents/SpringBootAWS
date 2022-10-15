package com.example.awstest2.controll;
import com.example.awstest2.mapper.NoticeMapper;
import com.example.awstest2.model.Notice;
import com.example.awstest2.model.Posting;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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



    @PostMapping("/upload")
    public ResponseEntity upload(@RequestPart MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        File destination = new File("upload/dir" + originalFileName);
        try {
            file.transferTo(destination);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(originalFileName);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(originalFileName);
    }

    @GetMapping("/upload/dir/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        return null;
    }

}
