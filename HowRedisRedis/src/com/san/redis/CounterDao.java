package com.san.redis;

import org.springframework.data.redis.core.RedisTemplate;

public class CounterDao {
	private RedisTemplate<String, String> redisTemplate;
	private String HASH_KEY = "UnRegisteredUserLoginAttemptCounterMap"; 
	
	public void logSignInAttempt(String userName) {
		int currentCount = getCurrentCount(userName);
		redisTemplate.opsForHash().put(userName, HASH_KEY, new Integer(currentCount + 1).toString());
		System.out.println("Counter for " + userName + " is " + currentCount);
    }
	
	public int getCurrentCount(String userName) {
		Object loginAttemptCount = redisTemplate.opsForHash().get(userName, HASH_KEY);
		int currentCounter = 0; 
		try {
			if(loginAttemptCount != null) {
				currentCounter = Integer.parseInt(loginAttemptCount.toString());
			}
		} catch(NumberFormatException ex) {
		}
		return currentCounter;
	}
	
	public void getAllEntries() {
	}
	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}