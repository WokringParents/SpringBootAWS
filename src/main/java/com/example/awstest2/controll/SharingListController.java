package com.example.awstest2.controll;

import com.example.awstest2.mapper.CalendarMapper;
import com.example.awstest2.mapper.SharingListMapper;
import com.example.awstest2.model.SharingList;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

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
    public int postSharingList(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") String sdate, @RequestParam("content") String content, @RequestParam("daily")Boolean daily,@RequestParam("enddate")String enddate){

      if(daily.booleanValue()){
          //데일리 스케쥴이라면
          String startdate= sdate.substring(0,10);  //0~9까지 yyyy-mm-dd
          return mapper.insertDailyList(couplenum,sdate,content,enddate,startdate);
      }
      else
      {
          return mapper.insertTodayList(couplenum,sdate,content);
      }
    }

    @DeleteMapping("/sharinglist/today")
    public int deleteTodaySharingList(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") String sdate){
        return mapper.deleteTodaySharingList(couplenum,sdate);
    }

    @DeleteMapping("/sharinglist/daily")
    public int deleteDailySharingList(@RequestParam("couplenum") int couplenum,@RequestParam("content") String content,@RequestParam("startdate") Timestamp startdate, @RequestParam("enddate") Timestamp enddate ){
        return mapper.deleteDailySharingList(couplenum,content,startdate,enddate);
    }



    @PutMapping("/sharinglist/mdo")
    public int putMaleDo(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") String sdate){
        return mapper.updateMaleDo(couplenum,sdate);
    }

    @PutMapping("/sharinglist/fdo")
    public int putFemaleDo(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") String sdate) {
        return mapper.updateFemaleDo(couplenum, sdate);
    }


    @DeleteMapping("/sharinglist/daily")
    public int putDailiyContent(@RequestParam("couplenum") int couplenum,@RequestParam("prevcontent") String prevcontent, @RequestParam("content") String content,@RequestParam("startdate") Timestamp startdate, @RequestParam("enddate") Timestamp enddate ){
        return mapper.updateDailyContent(couplenum,content,prevcontent,startdate,enddate);
    }

    @PutMapping("/sharinglist/today")
    public int putTodayContent(@RequestParam("couplenum") int couplenum, @RequestParam("sdate") String sdate, @RequestParam("content") String content){
        return mapper.updateTodayContent(couplenum,sdate,content);
    }

    //@RequestParam("prevcontent")String prevcontent
}
