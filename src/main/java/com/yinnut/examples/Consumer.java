package com.yinnut.examples;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {
	public static void main(String[] args) {
		Properties props = new Properties();
//		props.put("bootstrap.servers", "192.168.56.100:19092,192.168.56.101:19092,192.168.56.102:19092");
		props.put("bootstrap.servers", "192.168.1.117:9092,192.168.1.118:9092,192.168.1.119:9092");
		props.put("group.id", "nginx-log-consumer");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("appentry"));
		
		Integer count = Integer.valueOf(0);
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, key = %s, value = %s\n",
						record.offset(), record.key(), record.value());
				count = count + 1;				
			}
			
			if (count > 10) {
				break;
			}
		}
		consumer.close();
	}
}
