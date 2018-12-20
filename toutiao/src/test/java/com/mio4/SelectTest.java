package com.mio4;

import com.mio4.dao.NewsDao;
import com.mio4.dao.UserDao;
import com.mio4.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class SelectTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private NewsDao newsDao;

    @Test
    public void testSelect(){
         User user = userDao.selectById(2);
         System.out.println(user);
    }
}
