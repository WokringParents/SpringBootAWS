package com.example.awstest2.mapper;
import com.example.awstest2.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("Select * FROM User WHERE id= #{id}")
    User getUserProfile(@Param("id") String id);

    @Select("Select * FROM User WHERE email= #{email}")
    User getUserByEmail(@Param("email") String email);

    @Select("SELECT * FROM User")
    List<User> getUserProfileList();

    @Insert("INSERT INTO User VALUES(#{id}, #{pw}, #{email}, #{sex}, #{token})")
    int insertUserProfile(@Param("id") String id, @Param("pw") String pw, @Param("email") String email, @Param("sex") String sex, @Param("token") String token);

    //update User set token="changeToken" where id="tid2"
    @Update("UPDATE User SET token=#{token} WHERE id=#{id}")
    int updateUserToken(@Param("id") String id, @Param("token") String token);





    //  @Delete("DELETE FROM UserProfile WHERE id=#{id}")
  //  int deleteUserProfile(@Param("id") String id);

    //@Update("UPDATE Posting SET hcnt = hcnt-1 WHERE pno=#{pno}")
    //	int updateHcntMinus(@Param("pno")int pno);


    /*
    @Insert("INSERT INTO Posting (pid,pdate,pcontent) VALUES (#{pid},#{pdate},#{pcontent})")
	int insertBoardPosting(@Param("pid")String pid, @Param("pdate")Timestamp pdate, @Param("pcontent")String pcontent);


	@Update("UPDATE Posting SET hcnt = hcnt+1 WHERE pno=#{pno}")
	int updateHcntPlus(@Param("pno")int pno);
*/

}
