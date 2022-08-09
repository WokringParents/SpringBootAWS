package com.example.awstest2.controll;
import com.example.awstest2.mapper.CoupleCodeMapper;
import com.example.awstest2.mapper.CoupleMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoupleController {

    private CoupleMapper mapper;

    public CoupleController(CoupleMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/couple")
    public int postCouple(@RequestParam("mid") String mid, @RequestParam("did") String did) {
        return mapper.insertCouple(mid,did);
    }


}
