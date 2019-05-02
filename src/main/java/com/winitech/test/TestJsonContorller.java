package com.winitech.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestJsonContorller {
	
	@RequestMapping("viewJson")
	@ResponseBody
	public Map<String,String> viewjson() {
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", null);
		
		return map;
		
	}

}
