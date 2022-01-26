package com.project.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: Rrow
 * @Date: 2022/1/26 4:37 下午
 */

/**
 * 生产者程序,注意，这里要配置server.properties文件的 advertised.listeners=PLAINTEXT://xxx.xxx.xxx.xxx:9092 在zookeeper的外部暴露端口
 */
public class ProduceMsg {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "ecs01:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("kkk", null, i + "");
            Future<RecordMetadata> future = producer.send(record);
            // 等待响应
            System.out.println("future.get() = " + future.get());
            System.out.println("第" + i + "条消息，写入成功!!");
        }
        // 关闭生产者
        producer.close();

    }
}
