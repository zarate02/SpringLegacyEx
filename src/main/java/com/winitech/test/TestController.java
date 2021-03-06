package com.winitech.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winitech.test.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {
	
	@Resource TestService ts; 

	@RequestMapping("TestSelect")
	@ResponseBody
	public List<Map<String,Object>> testSelect(@RequestBody Map<String,String> parm) {
		log.info(parm.toString());
		return ts.TestSelect(parm);
	}

	@RequestMapping("TestInsert")
	@ResponseBody
	public String testInsert(@RequestBody Map<String,String> parm) {
		log.info("call TestInsert");
		return ts.TestInsert(parm);
	}
	
	@RequestMapping("TestUpdate")
	@ResponseBody
	public String testUpdate(@RequestBody Map<String,String> parm) {
		log.info("call TestUpdate");
		return ts.TestUpdate(parm);
	}
	
	@RequestMapping("TestDelete")
	@ResponseBody
	public String testDelete(@RequestBody Map<String,String> parm) {
		log.info("call TestDelete");
		return ts.TestDelete(parm);
	}
}
