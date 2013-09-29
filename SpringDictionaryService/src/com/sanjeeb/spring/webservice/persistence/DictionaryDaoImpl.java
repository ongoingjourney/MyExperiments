package com.sanjeeb.spring.webservice.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import com.sanjeeb.spring.webservice.model.Entity;

public class DictionaryDaoImpl implements DictionaryDao {
	private static final String SELECT_ALLWORDS_QUERY_STRING = "SELECT * FROM dictionary";
	private final String SELECT_DEFINITION_QUERY_STRING = "SELECT word, meaning FROM dictionary WHERE word=?";
	private final String INSERT_DEFINITION_QUERY_STRING = "INSERT INTO dictionary(word, meaning) VALUES (?, ?)";
	private final String DELTE_WORD_QUERY_STRING = "DELETE FROM dictionary WHERE word=?";
	
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Entity> getAllWords() {
		List<Entity> resultList = new LinkedList<>();
	    List resultSet = jdbcTemplate.query(SELECT_DEFINITION_QUERY_STRING, new MemberRowMapper()) ;
	    if(CollectionUtils.isEmpty(resultSet)) {
	    	throw new RuntimeException("Couldn't retrieve");
	    }
	    for(Object ob : resultSet) {
	    	resultSet.add((Entity)ob);
	    }
	    return resultList;
	}

	@Override
	public Entity getDefinition(Entity entityToLookUp) {
	    Object[] params = new Object[] {entityToLookUp.getWord()} ;
	    List result = jdbcTemplate.query(SELECT_DEFINITION_QUERY_STRING, params, new MemberRowMapper()) ;
	    if(CollectionUtils.isEmpty(result)) {
	    	throw new RuntimeException("Couldn't retrieve");
	    }
	    Entity word = (Entity)result.get(0) ;
	    System.out.println("getDefinition of " + word + "successful");
	    return word;
	}

	@Override
	public void addDefinition(Entity entity) {
		Object[] param = new Object[] {entity.getWord(), entity.getDefinition()};
		int rowsAffected = jdbcTemplate.update(INSERT_DEFINITION_QUERY_STRING, param);
		if(rowsAffected < 1) {
			throw new RuntimeException("Coudln't  " + entity);
		} else {
			System.out.println("insert of " + entity + " successful.");
		}
	}

	@Override
	public void deleteWord(Entity entity) {
		Object[] param = new Object[] {entity.getWord(), entity.getDefinition()};
		int rowsAffected = jdbcTemplate.update(DELTE_WORD_QUERY_STRING, param);
		if(rowsAffected < 1) {
			throw new RuntimeException("Couldn't delete " + entity);
		} else {
			System.out.println("deletion of " + entity + " successful.");
		}
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Required
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
class MemberRowMapper implements RowMapper {
    public Object mapRow(final ResultSet rs, int arg1) throws SQLException {
    	return new Entity(){
    		{
    			setWord(rs.getString("word"));
    			setDefinition(rs.getString("meaning"));
    		}
    	};
    }
}