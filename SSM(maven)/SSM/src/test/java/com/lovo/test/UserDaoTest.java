package com.lovo.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lovo.dao.UserDao;
import com.lovo.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManger", defaultRollback = false)
@Transactional
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void userDaoTest() {
		List users = userDao.findByName("lovo");
		for (Object user : users) {
			//写指定日志
			Log logger = LogFactory.getLog(UserDaoTest.class);
			logger.debug("输出日志222");
			System.out.println(user);
			userDao.addUser((User)user);
		}
	}
}
