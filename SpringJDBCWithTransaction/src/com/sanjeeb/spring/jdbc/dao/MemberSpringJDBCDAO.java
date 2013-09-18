package com.sanjeeb.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sanjeeb.spring.jdbc.model.Member;

public class MemberSpringJDBCDAO implements MemberDAO {
	private JdbcTemplate jdbcTemplate;
	
	private static final String insert_sql = "INSERT INTO puma_members VALUES(?,?,?,?,?,?,?)" ;
	private static final String select_sql = "SELECT * FROM puma_members WHERE email = ?" ;
	private static final String delete_sql = "DELTE FROM puma_members WHERE email = ?";  
		
	public int insertMember(Member member) {
	    JdbcTemplate jt = getJdbcTemplate();
	    Object[] params = new Object[] {member.getFirstName(),member.getLastName(),
	                           member.getStreet(),member.getCity(),member.getZip(),
	                           member.getEmail(),member.getPassword()} ;
	    
	    
	    int ret = jt.update(insert_sql, params) ;
	    System.out.println("ret = " + ret);
	    return ret ;
	}
	public Member getMember(String email) {
	    JdbcTemplate jt = getJdbcTemplate() ;
	    Object[] params = new Object[] {email} ;
	    List result = jt.query(select_sql,params, new MemberRowMapper()) ;
	    Member member = (Member)result.get(0) ;
	    return member;
	}
	
	private class MemberRowMapper implements RowMapper {
	    public Object mapRow(ResultSet rs, int arg1) throws SQLException {
	        Member member = new Member(rs.getString("firstname"), rs.getString("lastname"), 
	                                   rs.getString("street"), rs.getString("city"), rs.getString("zip"),
	                                   rs.getString("email"), rs.getString("password"));
	         
	        return member ;
	    }
	}

	@Override
	public int deleteMember(String email) {
		JdbcTemplate jt = getJdbcTemplate() ;
	    Object[] params = new Object[] {email} ;
	    int ret = jt.update(delete_sql,params, new MemberRowMapper()) ;
	    return ret;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}