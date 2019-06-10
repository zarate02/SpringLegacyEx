package com.winitech.util.groovy;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import lombok.extern.slf4j.Slf4j;

/****************
그루비 스크립트 해석기
*****************/
@Slf4j
public class GroovyUtil {

	final static String flodPath = "groovy";
	String FileNm;
	GroovyScriptEngine gse;
	Binding binding;
	String flodPath_2 = "";
	
	/*생성자*/
	public GroovyUtil(GroovyType gt) {
		flodPath_2 = flodPath + "/" + gt.getName();		
	}

	/*생성자에서 정의된 경로에서 특정파일을 지정한다*/
	public GroovyUtil create(String FileNm) {
		
		Resource resource = new ClassPathResource(flodPath_2);	
		try {
			gse = new GroovyScriptEngine(resource.getURI().getPath());
		}catch(IOException e) {
			log.info("Groovy Script Engine Creating Error : " + e.getMessage());
		}
		
		this.FileNm = FileNm+".groovy";
		
		return this;
	}
	
	/*스크립트 해석할때 첨부할 변수를 바인딩*/
	public GroovyUtil binding(Map<String, String> vo) {
		binding = new Binding();
		binding.setVariable("parm", vo);
		
		return this;
	}
	
	/*스크립트 해석할때 첨부할 변수를 바인딩(단일문자용)*/
	public GroovyUtil binding(String str) {
		
		binding = new Binding();
		binding.setVariable("parm", str);
		
		return this;
	}
	
	/*변수와함께 스크립트를 Exec*/
	public String exec() {
		String sqlstr = "Select 'Non' from Dual";
		
		try {
			sqlstr = gse.run(FileNm, binding).toString();
		}catch(Exception e) {
			sqlstr = "Err";
			log.info("[Groovy ERR] " + e.getMessage());
		}
		
		return sqlstr;
	}
	
	/*FTP전용*/
	public String[] exec_arr() {
		String[] strarr = new String[5];
		try {
			@SuppressWarnings("unchecked")
			List<String> resultlist = (List<String>) gse.run(FileNm, binding);
			
			strarr[0] = resultlist.get(0);
			strarr[1] = resultlist.get(1);
			strarr[2] = resultlist.get(2);
			strarr[3] = resultlist.get(3);
			strarr[4] = resultlist.get(4);
			
		}catch(Exception e) {
			log.info("[Groovy Strarr ERR] " + e.getMessage());
		}
		
		return strarr;
	}

}
