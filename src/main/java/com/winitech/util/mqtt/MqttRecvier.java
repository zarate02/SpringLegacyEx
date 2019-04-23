package com.winitech.util.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;
import com.winitech.test.TestVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MqttRecvier implements MqttCallback{

	@Override
	public void connectionLost(Throwable cause) {
		log.error("[MQTT RCIV] connectionLost");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		byte[] payload = message.getPayload();
		String text = new String(payload, "UTF-8");
		log.info("[MQTT RCIV] success : " + text);

		Gson gson = new Gson();
		TestVo cmb = gson.fromJson(text, TestVo.class);
		log.info(cmb.toString());
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		log.info("[MQTT RCIV] deliveryComplete");
	}

}
