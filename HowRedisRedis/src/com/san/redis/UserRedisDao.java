package com.san.redis;

public interface UserRedisDao {
	public int logSignInAttempt(CounterEntity counterEntity);
	public void clearAll();
}
