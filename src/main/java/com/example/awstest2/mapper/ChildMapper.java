package com.example.awstest2.mapper;

import com.example.awstest2.model.Child;
import com.example.awstest2.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface ChildMapper {

    @Select("SELECT * FROM Child")
    List<Child> getChildProfileList();

    @Select("SELECT * FROM Child WHERE couplenum=#{couplenum} AND name=#{name}")
    Child getChildProfile(@Param("couplenum") int couplenum, @Param("name")String name);

    @Select("SELECT * FROM Child WHERE couplenum=#{couplenum}")
    Child getChildHaving(@Param("couplenum") int couplenum);

    @Insert("INSERT INTO Child (couplenum,kname,name,sex) VALUES(#{couplenum}, #{kname}, #{name}, #{sex})")
    int insertChildProfile(@Param("couplenum") int couplenum, @Param("kname") String kname, @Param("name") String name, @Param("sex") String sex);

    @Select("SELECT pnumber FROM Child\n" +
            "inner join Couple on Child.couplenum = Couple.couplenum \n" +
            "inner join User on User.id = Couple.mid\n" +
            "where Child.couplenum =#{couplenum}")
    List<String> getFUserPnumber(@Param("couplenum") int couplenum);

    @Select("\n" +
            "SELECT pnumber FROM Child\n" +
            "inner join Couple on Child.couplenum = Couple.couplenum \n" +
            "inner join User on User.id = Couple.did  \n" +
            "where Child.couplenum =#{couplenum}")
    List<String> getMUserPnumber(@Param("couplenum") int couplenum);

    @Select("SELECT pnumber FROM Child\n" +
            "inner join Couple on Child.couplenum = Couple.couplenum \n" +
            "inner join User on User.id = Couple.mid\n" +
            "where Child.couplenum ={couplenum}")
    List<String> getFUserToken(@Param("couplenum") int couplenum);

    @Select("SELECT token FROM Child\n" +
            "inner join Couple on Child.couplenum = Couple.couplenum \n" +
            "inner join User on User.id = Couple.did\n" +
            "where Child.couplenum = #{couplenum}")
    List<String> getMUserToken(@Param("couplenum") int couplenum);


}
