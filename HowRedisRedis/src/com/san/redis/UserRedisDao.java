package com.san.redis;

import java.util.Map;

public interface UserRedisDao {
	public int logSignInAttempt(CounterEntity counterEntity);
	public void clearAll();
	public int getCurrentCountOfKey(String key);
	public Map<String, String> getAllEntries();
}
