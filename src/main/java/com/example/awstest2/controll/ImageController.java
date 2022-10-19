package com.example.awstest2.controll;

import com.example.awstest2.mapper.ImageMapper;
import com.example.awstest2.mapper.NoticeMapper;
import com.example.awstest2.model.Image;
import com.example.awstest2.model.Notice;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@RestController
public class ImageController {
    private ImageMapper mapper;

    public ImageController(ImageMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/postimage/{nid}")
    public int postImage(@PathVariable("nid") int nid, @RequestParam("image") String image) {
        return mapper.insertImage(image,nid);
    }

    @GetMapping("/getimage/{nid}")
    public List<Image> getImagebynid(@PathVariable("nid") int nid) {
        return mapper.getImagebynid(nid);
    }

}
