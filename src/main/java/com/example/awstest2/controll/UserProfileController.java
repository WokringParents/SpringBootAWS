package com.example.awstest2.controll;
import com.example.awstest2.mapper.UserProfileMapper;
import com.example.awstest2.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UserProfileController {

    private UserProfileMapper mapper;
    public UserProfileController(UserProfileMapper mapper){

        this.mapper = mapper;
    }

    @GetMapping("/user/{id}")

    public UserProfile getUserProfile(@PathVariable("id") String id){

        return mapper.getUserProfile(id);

    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList(){
    return new ArrayList<UserProfile>(mapper.getUserProfileList());
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address") String address){
        UserProfile userProfile =new UserProfile(id,name,phone,address);

        mapper.updateUserProfile(id,name, phone, address);

    }

    @PostMapping("/user/{id}")

    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address") String address) {
        mapper.insertUserProfile(id,name,phone,address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
        mapper.deleteUserProfile(id);
    }


}