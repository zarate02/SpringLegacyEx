package com.winitech.util.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MqttInfo {

	private IMqttClient sampleClient;
	private String url;
	private String client;
	private MqttConnectOptions connOpts;

	/*MQTT 설정값*/
	MqttInfo(){		
		url = "tcp://192.168.15.212:1883";
		client = "tttsss";
		
		connOpts = new MqttConnectOptions();
	    connOpts.setCleanSession(true);
        connOpts.setKeepAliveInterval(60);
        connOpts.setConnectionTimeout(30);
	}
	
	
	public IMqttClient getClient() {
		return sampleClient;
	}
		
	public void connect(){
		try {			
			
			/*MQTT서버에 새로운 접속시도*/
			if(sampleClient == null) {
				MemoryPersistence persistence = new MemoryPersistence();
				sampleClient = new MqttClient(url, client, persistence);
				log.info("[MQTT] NewConnect");
			}
			
			/*MQTT서버에 재접속 시도*/
			if (!sampleClient.isConnected()) {
				sampleClient.connect(connOpts);
				log.info("[MQTT] ReConnect");
				
				/*구독 토픽추가*/
				sampleClient.setCallback(new MqttRecvier());
				sampleClient.subscribe("test001", 2);
				log.info("[MQTT RCIV TOPIC ADD] test001");
			}
		}catch( MqttException e ) {
			log.info("[MQTT ERR] " + e.getMessage());
		}
	}
	
}
