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
			if(sampleClient == null) {
				MemoryPersistence persistence = new MemoryPersistence();
				sampleClient = new MqttClient(url, client, persistence);
				log.info("[MQTT] NewConnect");
			}
			
			if (!sampleClient.isConnected()) {
				sampleClient.connect(connOpts);
				log.info("[MQTT] ReConnect");
				
				//reciver
				sampleClient.setCallback(new MqttRecvier());
				sampleClient.subscribe("test001", 0);
				log.info("[MQTT RCIV TOPIC ADD] test001");
				
				
			}
		}catch( MqttException e ) {
			log.info("[MQTT ERR] " + e.getMessage());
		}
	}
	
}
