package com.san.redis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

public class UserRedisDaoImpl implements UserRedisDao {
	private RedisTemplate<String, String> redisTemplate;
	private Long defaultTimeOut;
	
	@Override
	public int logSignInAttempt(CounterEntity counterEntity) {
		String emailAddress = counterEntity.getEmailAddress();
		Integer nextCount = getCurrentCount(emailAddress) + 1;
		String value = nextCount.toString();
		redisTemplate.opsForValue().set(emailAddress, value);
		redisTemplate.expire(emailAddress, defaultTimeOut, TimeUnit.SECONDS);
		return nextCount;
	}
	
	@Override
	public void clearAll() {
		Set<String> allKeys = redisTemplate.keys("*");
		if(allKeys != null && allKeys.size()>0) {
			System.out.println("**Clearing all of " + allKeys.size() + " instances of keys that exists in redis**");
			redisTemplate.delete(allKeys);		
		}
	}
 	
	private int getCurrentCount(String userName) {
		int currentCounter = 0; 
		try {
			Object loginAttemptCount = redisTemplate.opsForValue().get(userName);
			if(loginAttemptCount != null) {
				currentCounter = Integer.parseInt(loginAttemptCount.toString());
			}
		} catch(Exception ex) {
			return 0;
		}
		return currentCounter;
	}
	
	public void getAllEntries() {
	}
	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	public void setDefaultTimeOut(Long defaultTimeOut) {
		this.defaultTimeOut = defaultTimeOut;
	}
}