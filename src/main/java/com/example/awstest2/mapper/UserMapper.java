package com.example.awstest2.mapper;
import com.example.awstest2.model.Child;
import com.example.awstest2.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("Select * FROM User WHERE id= #{id}")
    User getUserProfile(@Param("id") String id);

    @Select("Select * FROM User WHERE email= #{email}")
    User getUserByEmail(@Param("email") String email);

    @Select("SELECT token FROM User WHERE village=#{village}")
    List<String> getUserTokenList(@Param("village") String village);

    @Select("SELECT * FROM User")
    List<User> getUserProfileList();

    @Insert("INSERT INTO User VALUES(#{id}, #{pw}, #{email}, #{sex}, #{token}, #{name}, #{pnumber}, #{city}, #{village})")
    int insertUserProfile(@Param("id") String id, @Param("pw") String pw, @Param("email") String email, @Param("sex") String sex, @Param("token") String token, @Param("name") String name, @Param("pnumber") String pnumber, @Param("city") String city, @Param("village") String village);

    @Update("UPDATE User SET token=#{token} WHERE id=#{id}")
    int updateUserToken(@Param("id") String id, @Param("token") String token);


}
