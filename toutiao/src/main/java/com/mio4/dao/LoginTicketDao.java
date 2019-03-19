package com.mio4.dao;


import com.mio4.model.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "loginTicketDao")
public interface LoginTicketDao {
    String TABLE_NAME = "login_ticket";
    String INSERT_FIELDS = "user_id,expired,status,ticket";
    String SELECT_FIELDS = "id," + INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") " +
            "values (#{userId},#{expired},#{status},#{ticket})"})
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int addTicket(LoginTicket ticket);

    @Select({"select ",SELECT_FIELDS, " from ",TABLE_NAME," where id = #{id}"})
    LoginTicket selectByTicket(String ticket);

    @Update({"update ",TABLE_NAME," set status=#{status} where ticket = #{ticket}"})
    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);

}
