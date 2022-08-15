package com.example.awstest2.controll;

import com.example.awstest2.mapper.CalendarMapper;
import com.example.awstest2.mapper.SharingListMapper;
import com.example.awstest2.model.SharingList;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class SharingListController {

    private SharingListMapper mapper;

    public SharingListController(SharingListMapper mapper) {
        this.mapper = mapper;
    }


    @GetMapping("/sharinglist")
    public List<SharingList> getSharingList(@RequestParam("couplenum") int couplenum, @RequestParam("startdate") Timestamp startdate, @RequestParam("enddate") Timestamp enddate){
        return mapper.selectSharingList(couplenum,startdate,enddate);
    }

    @PostMapping("/sharinglist")
    public int postSharingList(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") Timestamp sdate, @RequestParam("content") String content){
        return mapper.insertSharingList(couplenum,sdate,content);
    }

    @PutMapping("/sharinglist/mdo")
    public int putMaleDo(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") Timestamp sdate){
        return mapper.updateMaleDo(couplenum,sdate);
    }

    @PutMapping("/sharinglist/fdo")
    public int putFemaleDo(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") Timestamp sdate) {
        return mapper.updateFemaleDo(couplenum, sdate);
    }




}
