package com.example.awstest2.controll;
import com.example.awstest2.mapper.UserMapper;
import com.example.awstest2.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {

    private UserMapper mapper;
    public UserController(UserMapper mapper){
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}")
    public User getUserProfile(@PathVariable("id") String id){
        return mapper.getUserProfile(id);
    }

    @GetMapping("/useremail/{email}")
    public User getUserByEmail(@PathVariable("email") String email){

        return mapper.getUserByEmail(email);
    }

    @GetMapping("/user/all")
    public List<User> getUserProfileList(){
    return new ArrayList<User>(mapper.getUserProfileList());
    }

    @PostMapping("/user/{id}")
    public int postUserProfile(@PathVariable("id") String id, @RequestParam("pw") String pw,@RequestParam("email") String email,@RequestParam("sex") String sex, @RequestParam("token") String token) {
       return mapper.insertUserProfile(id,pw,email,sex,token);
    }

    @PutMapping("/user/{id}")
    public int putUserToken(@PathVariable("id") String id, @RequestParam("token")String token){
        return mapper.updateUserToken(id,token);
    }



  /*  @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
        mapper.deleteUserProfile(id);
    }
  */


    /*
    //글읽는사이에 다른 사람이 댓글을 추가하거나 공감하거나 등등 포스팅 정보의 변화가 생길 수있으므로 어플 자체에서 +1 한 값으로 업데이트를 하는게 아니라 DB값에서 +1을하던 -1을 하던 해줘야한다.
	@PutMapping("/posting/hcnt/{pno}")
	public int putHeartCnt(@PathVariable("pno")int pno, @RequestParam("sign")String sign) {

		if(sign.equals("plus")) {
			return mapper.updateHcntPlus(pno);
		}
		else
		{
			return mapper.updateHcntMinus(pno);
		}
	}

	@PutMapping("/posting/vcnt/{pno}")
	public int putViewsCnt(@PathVariable("pno")int pno) {
		return mapper.updateVcntPlus(pno);
	}

	@DeleteMapping("/posting/delete")
	public int deleteBoardPosting(@RequestParam("pno")int pno) {
		return mapper.deleteBoardPosting(pno);
	}*/

}