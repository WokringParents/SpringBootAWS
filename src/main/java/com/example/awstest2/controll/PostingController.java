package com.example.awstest2.controll;

import com.example.awstest2.mapper.PostingMapper;
import com.example.awstest2.model.Posting;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@RestController
public class PostingController {

    private PostingMapper mapper;

    public PostingController(PostingMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/posting/all")        //서버인터네셔널 오류
    public List<Posting> getBoardPosting() {

        //offset은 어디서부터 가지고 올 것인지 가져올 개수는 항상 고정된개수로 가져온다. 10개정도?
        // field는 뭐를 기준으로 정렬해서 가지고 올 것인지. 날짜?조회수?공감순?
        return mapper.getBoardPosting();
    }

    @GetMapping("/posting/{attribute}")
    public List<Posting> getBoardOffset(@PathVariable("attribute") String attribute) {

        if (attribute.equals("pdate")) {
            return mapper.getBoardPosting();
        } else if (attribute.equals("hcnt")) {
            return mapper.getBoardOffsetbyHcnt();
        } else {
            return mapper.getBoardOffsetbyCcnt();
        }
    }


    @GetMapping("/postingContent/{content}")    //ㄹㅇ 편식해서 들고옴 이해안됨
    public List<Posting> getPostingbyContent(@PathVariable("content") String content) {
        return mapper.getPostingbyContent(content);
    }

    @PostMapping("/posting/{pid}")        //서버 인터네셔널 오류
    public Posting postBoardPosting(@PathVariable("pid") String pid, @RequestParam("village") String village, @RequestParam("goback") String goback,
                                @RequestParam("content") String content) {

        //생각해보니 pdate 도 sysdate하면 되지 않을까?
        //pno는 자동추가, cnt 종류들은 디폴트가 0 이니까 필요 엑스, pdate는 시스템 현재 시간
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        Timestamp pdate = new Timestamp(System.currentTimeMillis());
        mapper.insertBoardPosting(pid, village, goback, pdate, content);
        return mapper.getBoardPostingbyPno(pid,pdate,content);
    }

    @PutMapping("/posting/ccnt/{pno}")
    public int putCommentCnt(@PathVariable("pno") int pno, @RequestParam("sign") String sign) {

        if (sign.equals("plus")) {
            return mapper.updateCcntPlus(pno);
        } else {
            return mapper.updateCcntMinus(pno);
        }
    }

    //글읽는사이에 다른 사람이 댓글을 추가하거나 공감하거나 등등 포스팅 정보의 변화가 생길 수있으므로 어플 자체에서 +1 한 값으로 업데이트를 하는게 아니라 DB값에서 +1을하던 -1을 하던 해줘야한다.
    @PutMapping("/posting/hcnt/{pno}")
    public int putHeartCnt(@PathVariable("pno") int pno, @RequestParam("sign") String sign) {

        if (sign.equals("plus")) {
            return mapper.updateHcntPlus(pno);
        } else {
            return mapper.updateHcntMinus(pno);
        }
    }

    @DeleteMapping("/posting/delete")
    public int deleteBoardPosting(@RequestParam("pno") int pno) {
        return mapper.deleteBoardPosting(pno);

    }
}
