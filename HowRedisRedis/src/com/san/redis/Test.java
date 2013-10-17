package com.san.redis;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		UserRedisDao userRedisDao = (UserRedisDao)factory.getBean("userRedisDaoProxy");
		//fillDataInRedis(userRedisDao);
		//printAllDataInRedis(userRedisDao);
		//userRedisDao.clearAll();
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("san@mail.com");}});
		System.out.println(userRedisDao.getCurrentCountOfKey("san@mail.com"));
    }
		
	private static void fillDataInRedis(UserRedisDao userRedisDao)  {
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("abcd@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("abcd@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("abcd@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("abcd@mail.com");}});
		
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("def@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("def@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("def@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("def@mail.com");}});
		
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("pqr@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("pqr@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("pqr@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("pqr@mail.com");}});
		
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("xyz@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("xyz@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("xyz@mail.com");}});
		userRedisDao.logSignInAttempt(new CounterEntity(){{setEmailAddress("xyz@mail.com");}});
		}

    private static void printAllDataInRedis(UserRedisDao userRedisDao) {
		Map<String, String> allEntries = userRedisDao.getAllEntries();
		if (allEntries != null && allEntries.size()>0) {
			Set<String> keySet = allEntries.keySet();
			for(String key : keySet) {
				System.out.println(key + ":" + allEntries.get(key));
			}
		}
	}
}