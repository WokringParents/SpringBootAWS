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
    @GetMapping("/childHaving/{couplenum}")
    public Child getChildHaving(@PathVariable("couplenum") int couplenum) {
        return mapper.getChildHaving(couplenum);
    }


    //등하원게시판에서 부모님 폰번호와 토큰 가져오기
    //User에 적어야하나 Child에 적어야하나 하다가..
    //일단 여기 적었습니당
    @GetMapping("/pnumberForGoback/{couplenum}")
    public ArrayList<String> getUserPnumber(@PathVariable("couplenum") int couplenum) {
        ArrayList<String> MomPnumber= new ArrayList<String>(mapper.getFUserPnumber(couplenum));
        ArrayList<String> DadPnumber= new ArrayList<String>(mapper.getMUserPnumber(couplenum));
        MomPnumber.addAll(DadPnumber);
        return MomPnumber;
    }

    @GetMapping("/tokenForGoback/{couplenum}")
    public ArrayList<String> getUserToken(@PathVariable("couplenum") int couplenum) {
        ArrayList<String> MomToken= new ArrayList<String>(mapper.getFUserToken(couplenum));
        ArrayList<String> DadToken= new ArrayList<String>(mapper.getMUserToken(couplenum));
        MomToken.addAll(DadToken);
        return MomToken;
    }

    @PostMapping("/child/{couplenum}")
    public int postChildProfile(@PathVariable("couplenum") int couplenum, @RequestParam("kname") String kname,  @RequestParam("name") String name,  @RequestParam("sex") String sex) {
        return mapper.insertChildProfile(couplenum, kname, name, sex);
    }

}
