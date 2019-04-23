package com.winitech.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winitech.util.mqtt.MqttSender;

@Controller
public class TestMqttContorller {
	
	@Resource MqttSender ms;

	@RequestMapping("TestMq")
	@ResponseBody
	public String testSelect() {
		
		TestVo vo = new TestVo();
		vo.setTestval1("1");
		vo.setTestval2(2);
		vo.setTestval3(true);
		ms.send("test001", vo);
		
		return "ok";
	}

}
