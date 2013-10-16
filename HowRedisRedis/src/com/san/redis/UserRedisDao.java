package com.san.redis;

import java.util.Map;

public interface UserRedisDao {
	public int logSignInAttempt(CounterEntity counterEntity);
	public void clearAll();
	public Map<String, String> getAllEntries();
}
