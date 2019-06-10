package com.winitech.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winitech.test.service.MqttService;

@Controller
public class TestMqttContorller {
	
	@Resource MqttService ms;

	@RequestMapping("TestMq")
	@ResponseBody
	public String testSelect() {
		
		ms.send();
		
		return "ok";
	}

}
