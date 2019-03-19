package com.mio4.service;

import com.mio4.dao.LoginTicketDao;
import com.mio4.dao.UserDao;
import com.mio4.model.LoginTicket;
import com.mio4.model.User;
import com.mio4.util.ToutiaoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginTicketDao loginTicketDao;

    public User getUser(int id){
        return userDao.selectById(id);
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    public Map<String,Object> register(String username, String password){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        User user = userDao.selectByUsername(username);
        if(user != null){
            map.put("msgname","用户已经被注册");
            return map;
        }

        user = new User();
        user.setUsername(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5)); //密码salt
        user.setHead_url(String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setPassword(ToutiaoUtil.MD5(password + user.getSalt()));
        userDao.addUser(user);
        //TODO 登录
        return map;
    }

    public Map<String,Object> login(String username, String password){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        User user = userDao.selectByUsername(username);
        if(user == null){
            map.put("msgname","用户名不存在");
            return map;
        }
        if(!ToutiaoUtil.MD5(password+user.getSalt()).equals(user.getPassword())){
            map.put("msgpawd","密码不正确");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }

    private String addLoginTicket(int userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*24);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replace("-",""));
        loginTicketDao.addTicket(loginTicket);
        return loginTicket.getTicket();
    }


}

















