package com.winitech.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Resource SqlSession ss;
	
	public List<Map<String,Object>> TestSelect(Map<String,Object> parm) {
		return ss.selectList("S_WARDCAR_DG", parm);
	}
	
	public String TestInsert(Map<String,Object> parm) {
		try {
			return (1==ss.insert("I_WARDCAR_DG", parm)) ? "success" : "fail";
		} catch(DuplicateKeyException e) {
			return "fail : DuplicateKeyException";
		} catch(Exception e) {
			return "fail";
		}
		
	}

	public String TestUpdate(Map<String,Object> parm) {
		try {
			return (1==ss.update("U_WARDCAR_DG", parm)) ? "success" : "fail";
		} catch(Exception e) {
			return "fail";
		}
	}
	
	public String TestDelete(Map<String,Object> parm) {
		try {
			return (1==ss.delete("D_WARDCAR_DG", parm)) ? "success" : "fail";
		} catch(Exception e) {
			return "fail";
		}
	}
	
}
