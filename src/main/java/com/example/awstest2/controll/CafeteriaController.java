package com.example.awstest2.controll;

import com.example.awstest2.mapper.CafeteriaMapper;
import com.example.awstest2.model.Cafeteria;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CafeteriaController {

    private CafeteriaMapper mapper;

    public CafeteriaController(CafeteriaMapper mapper){this.mapper=mapper;}

    @PostMapping("/cafeteria")
    public int postCafeteria( @RequestParam("tid") int tid, @RequestParam("cdate")String cdate, @RequestParam("ctype")int ctype, @RequestParam("content")String content, @RequestParam("image") String image){
        return mapper.insertCafeteria(tid,cdate,ctype,content,image);
    }

    @GetMapping("/cafeteria")
    public List<Cafeteria> getCafeteria(@RequestParam("tid")int tid){
        return mapper.selectCafeteria(tid);
    }

    @DeleteMapping("/cafeteria")
    public int deleteCafeteria(@RequestParam("tid")int tid, @RequestParam("cdate")String cdate, @RequestParam("ctype")int ctype){
       return mapper.deleteCafeteria(tid,cdate,ctype);
    }

    @PutMapping("/cafeteria")
    public int putCafeteria(@RequestParam("tid")int tid, @RequestParam("cdate")String cdate, @RequestParam("ctype")int ctype, @RequestParam("content")String content, @RequestParam("image")String image){
        return mapper.updateCafeteria(tid,cdate,ctype,content,image);
    }
}
