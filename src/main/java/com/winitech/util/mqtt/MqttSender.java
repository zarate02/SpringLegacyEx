package com.winitech.util.mqtt;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.winitech.test.TestVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MqttSender {

	@Resource MqttInfo mi;
	
	public void send(String topic, TestVo vo) {	    
		IMqttClient mc = mi.getClient();
		
		if(mc==null)
			log.error("[Mqtt Send] connect is null");
			
		else if (!mc.isConnected()) 
			log.error("[Mqtt Send] not Connected");
		
		else {
			Gson gson = new GsonBuilder().create();
		    String obj = gson.toJson(vo);
		    
		    MqttMessage message = null;
	    	try {
				message = new MqttMessage(obj.getBytes("UTF-8"));
			    message.setQos(0);
				mc.publish(topic, message);
			} catch (UnsupportedEncodingException e) {
				log.error("object encoding Err");
			} catch (MqttPersistenceException e) {
				log.error("MqttPersistenceException : " + e);
			} catch (MqttException e) {
				log.error("MqttException : " + e);
			} 
	
		    log.info("[MQTT SEND] success : " + obj);	//ok Thank you
		}
	}
}
