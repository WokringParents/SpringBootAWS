package com.example.awstest2.controll;
import com.example.awstest2.mapper.UserMapper;
import com.example.awstest2.model.Child;
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

    @GetMapping("/usertoken/{village}")
    public List<String> getTokenListByVillage(@PathVariable("village")String village){
        return mapper.getUserTokenList(village);
    }

    @GetMapping("/user/all")
    public List<User> getUserProfileList(){
        return new ArrayList<User>(mapper.getUserProfileList());
    }

    @PostMapping("/user/{id}")
    public int postUserProfile(@PathVariable("id") String id, @RequestParam("pw") String pw,@RequestParam("email") String email,@RequestParam("sex") String sex, @RequestParam("token") String token, @RequestParam("name") String name, @RequestParam("pnumber") String pnumber, @RequestParam("city") String city,@RequestParam("village") String village) {
        return mapper.insertUserProfile(id,pw,email,sex,token,name,pnumber,city,village);
    }

    @PutMapping("/user/{id}")
    public int putUserToken(@PathVariable("id") String id, @RequestParam("token")String token){
        return mapper.updateUserToken(id,token);
    }




}