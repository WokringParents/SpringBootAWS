package com.example.awstest2.controll;

import com.example.awstest2.mapper.ChildMapper;
import com.example.awstest2.model.Child;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@RestController
public class ChildController {

    private ChildMapper mapper;
    public ChildController(ChildMapper mapper){
        this.mapper = mapper;
    }

    @GetMapping("/child/all")
    public List<Child> getChildProfileList(){
        return new ArrayList<Child>(mapper.getChildProfileList());
    }

    @GetMapping("/child/{couplenum}")
    public Child getChildProfile(@PathVariable("couplenum") int couplenum, @RequestParam("name")String name) {
        System.out.println(couplenum+name);
        return mapper.getChildProfile(couplenum,name);
    }

    @PostMapping("/child/{couplenum}")
    public int postChildProfile(@PathVariable("couplenum") int couplenum, @RequestParam("kname") String kname,  @RequestParam("name") String name,  @RequestParam("sex") String sex) {
        return mapper.insertChildProfile(couplenum, kname, name, sex);
    }


}
