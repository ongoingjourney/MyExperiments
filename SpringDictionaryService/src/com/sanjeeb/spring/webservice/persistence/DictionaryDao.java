package com.sanjeeb.spring.webservice.persistence;

import java.util.List;

import com.sanjeeb.spring.webservice.model.Entity;

public interface DictionaryDao {
	public List<Entity> getAllWords();
	public Entity getDefinition(Entity entity);
	public void addDefinition(Entity entity);
	public void deleteWord(Entity entity);
}