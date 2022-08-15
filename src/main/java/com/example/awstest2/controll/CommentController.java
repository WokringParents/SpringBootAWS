package com.example.awstest2.controll;

import com.example.awstest2.mapper.CommentMapper;
import com.example.awstest2.model.Comment;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@RestController
public class CommentController {

    private CommentMapper mapper;

    public CommentController(CommentMapper mapper) {
        this.mapper=mapper;
    }

    @GetMapping("/comment/{pno}")
    public List<Comment> getComment(@PathVariable("pno")int pno){
        return mapper.getComments(pno);
    }

    @PostMapping("/comment/{pno}")
    public Comment postComment(@PathVariable("pno") int pno, @RequestParam("cno")int cno, @RequestParam("cid")String cid, @RequestParam("cment")String cment){

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        Timestamp cdate = new Timestamp(System.currentTimeMillis());

        mapper.postComment(pno,cno,cid,cment,cdate);
        return mapper.getComment(pno, cno);
    }

    @PutMapping("/comment/{pno}")
    public int putCcommentCnt (@PathVariable("pno")int pno, @RequestParam("cno")int cno, @RequestParam("sign") String sign) {

        if(sign.equals("plus")) {
            return mapper.updateCccntPlus(pno,cno);
        }
        else
        {
            return mapper.updateCccntMinus(pno,cno);
        }
    }

    @DeleteMapping("/comment/delete")
    public int deleteComment(@RequestParam("pno")int pno, @RequestParam("cno")int cno) {

        return mapper.deleteComment(pno,cno);
    }
}