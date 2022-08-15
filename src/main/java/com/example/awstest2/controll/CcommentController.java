package com.example.awstest2.controll;

import com.example.awstest2.mapper.CcommentMapper;
import com.example.awstest2.model.Ccomment;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@RestController
public class CcommentController {


    private CcommentMapper mapper;

    public CcommentController(CcommentMapper mapper) {
        this.mapper=mapper;
    }

    @GetMapping("/ccomment/{pno}")
    public List<Ccomment> getCcomments(@PathVariable("pno")int pno) {
        return mapper.getCcomments(pno);
    }

    @PostMapping("/ccomment/{pno}")
    public Ccomment postCcomment(@PathVariable("pno")int pno, @RequestParam("cno")int cno, @RequestParam("ccno") int ccno, @RequestParam("ccid")String ccid, @RequestParam("ccment") String ccment)
    {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        Timestamp ccdate = new Timestamp(System.currentTimeMillis());


        mapper.postCcomment(pno,cno,ccno,ccid,ccment,ccdate);
        return mapper.getCcomment(pno,cno,ccno);
    }

    @DeleteMapping("/ccomment/delete")
    public int deleteCcomment(@RequestParam("pno")int pno, @RequestParam("cno")int cno, @RequestParam("ccno")int ccno)
    {
        return mapper.deleteCcomment(pno,cno,ccno);
    }

}
