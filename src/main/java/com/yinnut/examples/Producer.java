package com.yinnut.examples;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
    	Properties props = new Properties();
//    	props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.100:19092,192.168.56.101:19092,192.168.56.102:19092");
    	props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.117:9092,192.168.1.118:9092,192.168.1.119:9092");
    	props.put(ProducerConfig.RETRIES_CONFIG, "3");
    	props.put(ProducerConfig.ACKS_CONFIG, "all");
    	props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "none");
    	props.put(ProducerConfig.BATCH_SIZE_CONFIG, 200);
    	props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
    	props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//    	props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");

    	KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
    	
    	//"1"是partition的key，决定放到物理上哪个分区的，一般重载partition，可以在Properties里面指定
    	producer.send(new ProducerRecord<>("appentry", "1", "who cares risk?")).get();
    	
    }
}

