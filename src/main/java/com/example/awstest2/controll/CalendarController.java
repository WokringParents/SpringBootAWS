package com.example.awstest2.controll;

import com.example.awstest2.mapper.CalendarMapper;
import com.example.awstest2.model.Calendar;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@RestController
public class CalendarController {

    private CalendarMapper mapper;

    public CalendarController(CalendarMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/calendar/{couplenum}")
    public List<Calendar> getCalender(@PathVariable("couplenum") int couplenum){
        return mapper.getCalendar(couplenum);
    }

    @PostMapping("/calendar/{couplenum}")
    public int insertCalender(@PathVariable("couplenum") int couplenum, @RequestParam("ctitle") String ctitle, @RequestParam("ccontent") String ccontent, @RequestParam("csex") String csex) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        Timestamp cdate = new Timestamp(System.currentTimeMillis());

        return mapper.insertCalendar(couplenum,cdate,ctitle,ccontent,csex);
    }

}
