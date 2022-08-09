package com.example.awstest2.controll;
import com.example.awstest2.mapper.CoupleCodeMapper;
import com.example.awstest2.model.CoupleCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.TimeZone;


@RestController
public class CoupleCodeController {

    private CoupleCodeMapper mapper;

    public CoupleCodeController(CoupleCodeMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/couplecode/{code}")
    public String getSpouseID(@PathVariable("code") String code){
        return mapper.selectCID(code);
    }

    @PostMapping("/couplecode/{code}")
    public int postCode(@PathVariable("code") String code, @RequestParam("id") String cid){

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        Timestamp ctime = new Timestamp(System.currentTimeMillis());

        return mapper.insertCoupleCode(code,ctime,cid);

    }

    @DeleteMapping("/couplecode/delete")
    public int deleteCode(@RequestParam("code") String code){
        return mapper.deleteCoupleCode(code);
    }



}
