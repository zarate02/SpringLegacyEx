package com.winitech.util.mqtt;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MqttCron {
	
	@Resource MqttInfo mi;
		
	@Scheduled(fixedDelay=10000)
	public void mqttjob() {
		log.info("q check");
		mi.connect();		
	}

}
