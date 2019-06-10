package com.winitech.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.winitech.test.vo.TestVo;
import com.winitech.util.mqtt.MqttSender;

@Service
public class MqttService {

	@Resource MqttSender ms;
	
	public void send() {	
		TestVo vo = new TestVo();
		vo.setTestval1("1");
		vo.setTestval2(2);
		vo.setTestval3(true);
		ms.send("test001", vo);
	}
}
