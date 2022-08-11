package com.example.awstest2.controll;
import com.example.awstest2.mapper.CoupleCodeMapper;
import com.example.awstest2.mapper.CoupleMapper;
import com.example.awstest2.model.Couple;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoupleController {

    private CoupleMapper mapper;

    public CoupleController(CoupleMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/couple/{id}")
    public Couple getCoupleNum(@PathVariable("id")String id){
        return mapper.selectCouple(id);
    }

    @PostMapping("/couple")
    public int postCouple(@RequestParam("mid") String mid, @RequestParam("did") String did) {
        return mapper.insertCouple(mid,did);
    }

    @PostMapping("/couple/address")
    public int postAddress(@RequestParam("city") String city, @RequestParam("village") String village) {
        return mapper.insertAddress(city,village);
    }


}
