package com.mio4.dao;

import com.mio4.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "userDao")
public interface UserDao {
    String TABLE_NAME = "user";
    String INSERT_FIELDS = "username,password,salt,head_url";
    String SELECT_FIELDS = "id, username, password,salt, head_url";

    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") " +
            "values (#{username},#{password},#{salt},#{head_url})"})
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int addUser(User user);

    //@Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where id = #{id}"})
    @Select({"select id,username,head_url from ",TABLE_NAME," where id = #{id}"})
    User selectById(int id);

    @Update({"update ",TABLE_NAME," set password = #{password} where id = #{id}"})
    void updateUser(User user);

    @Delete({"delete from ",TABLE_NAME," where id = #{id}"})
    void deleteById(int id);

    @Select({"select * from ",TABLE_NAME," where username = #{username}"})
    User selectByUsername(String username);
}
