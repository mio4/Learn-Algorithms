package com.mio4;

import com.mio4.dao.LoginTicketDao;
import com.mio4.dao.NewsDao;
import com.mio4.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
@WebAppConfiguration
public class ToutiaoApplicationTests {
	@Autowired
	UserDao userDao;

	@Autowired
	NewsDao newsDao;

	@Autowired
	LoginTicketDao loginTicketDao;

	@Test
	public void contextLoads() {
	}

}
