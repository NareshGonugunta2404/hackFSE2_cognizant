package com.united.stock.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	/* To create topic
	 * kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
	 */
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.topic.name}")
	String kafkaTopic;
	
	public void send(String message) {
		//System.out.println("kafka topic name :" +kafkaTopic);
		kafkaTemplate.send(kafkaTopic, message);
	}

}
