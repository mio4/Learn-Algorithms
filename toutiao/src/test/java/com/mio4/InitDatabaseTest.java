package com.mio4;

import com.mio4.dao.LoginTicketDao;
import com.mio4.dao.NewsDao;
import com.mio4.dao.UserDao;
import com.mio4.model.LoginTicket;
import com.mio4.model.News;
import com.mio4.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
@Sql("/InitSchema.sql")
public class InitDatabaseTest implements Serializable {
    @Autowired
    UserDao userDao;

    @Autowired
    NewsDao newsDao;

    @Autowired
    LoginTicketDao loginTicketDao;

    @Test
    public void initData(){
        Random random = new Random();
        for(int i=0; i < 11; i++){
            User user = new User();
            user.setHead_url(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setUsername(String.format("USER%d", i));
            user.setPassword("");
            user.setSalt("");
            userDao.addUser(user);

            News news = new News();
            news.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*5*i);
            news.setCreatedDate(date);
            news.setImage(String.format("http://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
            news.setLikeCount(i+1);
            news.setUserId(i+1);
            news.setTitle(String.format("TITLE{%d}", i));
            news.setLink(String.format("http://www.toutiao.com/%d.html", i));
            newsDao.addNews(news);

            user.setPassword("new password");
            userDao.updateUser(user);

            //ticket测试
            LoginTicket ticket = new LoginTicket();
            ticket.setStatus(0);
            ticket.setUserId(100);
            ticket.setExpired(date);
            ticket.setTicket(String.format("TICKET%d",i+1));
            loginTicketDao.addTicket(ticket);

            loginTicketDao.updateStatus(ticket.getTicket(),2);
        }
    }

}
