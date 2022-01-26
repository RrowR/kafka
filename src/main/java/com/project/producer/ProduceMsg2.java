package com.project.producer;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: Rrow
 * @Date: 2022/1/26 4:37 下午
 */

/**
 * 使用异步回调的方式发送消息
 */
public class ProduceMsg2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger logger = LoggerFactory.getLogger(ProduceMsg2.class);
        Properties props = new Properties();
        props.put("bootstrap.servers", "ecs01:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            // ProducerRecord<String, String> record = new ProducerRecord<>("kkk", null, i + "");
            // Future<RecordMetadata> future = producer.send(record);
            // // 等待响应
            // System.out.println("future.get() = " + future.get());
            // System.out.println("第" + i + "条消息，写入成功!!");

            // 使用异步回调的方式
            ProducerRecord<String, String> record = new ProducerRecord<>("kkk", null, i + "");
            /*
                exception – The exception thrown during processing of this record.
                metadata - 消息的元数据 (属于哪个topic、属于哪个partition、对应的offset是什么)
             */
            producer.send(record, (metadata, exception) -> {
                // 如果为空，代表消息发送成功，如果不为空，则发送失败
                if (exception == null) {
                    logger.info("消息发送成功!!!");
                    // 主题
                    System.out.println("metadata.topic() = " + metadata.topic());
                    // 分区
                    System.out.println("metadata.partition() = " + metadata.partition());
                    // 偏移量
                    System.out.println("metadata.offset() = " + metadata.offset());
                } else {
                    logger.error("发送出现错误!!!");
                    logger.error(exception.getMessage());
                    logger.error(String.valueOf(exception.getStackTrace()));
                }
            });
        }
        // 关闭生产者
        producer.close();

    }
}
