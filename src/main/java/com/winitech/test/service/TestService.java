package com.winitech.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.winitech.util.groovy.GroovyType;
import com.winitech.util.groovy.GroovyUtil;

@Service
public class TestService {
	
	@Resource SqlSession sqlSession;
	
	public List<Map<String,Object>> TestSelect(Map<String,String> vo) {
		Map<String, String> parm = new HashMap<String, String>();
		parm.put("SQL_A", new GroovyUtil(GroovyType.SERVICE).create("TestSelect").binding(vo).exec());								
		return sqlSession.selectList("SELECT_SQL", parm);
		 
	}
	
	public String TestInsert(Map<String,String> vo) {		
		Map<String, String> parm = new HashMap<String, String>();
		parm.put("SQL_A", new GroovyUtil(GroovyType.SERVICE).create("TestInsert").binding(vo).exec());
								
		try {
			return (1==sqlSession.insert("INSERT_SQL", parm)) ? "success" : "fail";
		} catch(DuplicateKeyException e) {
			return "fail : DuplicateKeyException";
		} catch(Exception e) {
			return "fail";
		}
	}

	public String TestUpdate(Map<String,String> vo) {
		Map<String, String> parm = new HashMap<String, String>();
		parm.put("SQL_A", new GroovyUtil(GroovyType.SERVICE).create("TestUpdate").binding(vo).exec());
		
		try {
			return (1==sqlSession.update("UPDATE_SQL", parm)) ? "success" : "fail";
		} catch(Exception e) {
			return "fail";
		}
	}
	
	public String TestDelete(Map<String,String> vo) {
		Map<String, String> parm = new HashMap<String, String>();
		parm.put("SQL_A", new GroovyUtil(GroovyType.SERVICE).create("TestDelete").binding(vo).exec());
		
		try {
			return (1==sqlSession.delete("DELETE_SQL", parm)) ? "success" : "fail";
		} catch(Exception e) {
			return "fail";
		}
	}
	
}
