package com.mio4;

import com.mio4.dao.NewsDao;
import com.mio4.dao.UserDao;
import com.mio4.model.News;
import com.mio4.model.User;
import org.junit.Assert;
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
    private UserDao userDao;

    @Autowired
    private NewsDao newsDao;

    @Test
    public void initData(){
        Random random = new Random();
        for(int i=0; i < 11; i++){
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setName(String.format("USER%d", i));
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

        }

        User user = userDao.selectById(1);
        Assert.assertEquals("new password",userDao.selectById(1).getPassword());
        userDao.deleteById(1);
        Assert.assertNull(userDao.selectById(1));
    }

//    @SelectTest
//    public void testSelectUser(){
//        User user = userDao.selectById(2);
//        System.out.println(user);
//    }
}
