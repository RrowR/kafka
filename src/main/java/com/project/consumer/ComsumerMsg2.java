package com.project.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * atlan 2022/1/26 18:14
 */
public class ComsumerMsg2 {

    private static Logger logger = LoggerFactory.getLogger(ComsumerMsg2.class);

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        // Kafka服务器
        props.setProperty("bootstrap.servers", "ecs01:9092");
        /*
            消费者组，如果消费者组名是一样的，那么就可以消费同一份数据，可以起多个
         */
        props.setProperty("group.id", "test");
        // 自动提交offset(偏移量)
        props.setProperty("enable.auto.commit", "true");
        // 自动提交offset的提交间隔
        props.setProperty("auto.commit.interval.ms", "10");
        // 解析格式
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // 指定从哪个topic里消费
        consumer.subscribe(Arrays.asList("kkk","lll","ppp"));
        // 死循环，主动去拉数据
        while (true) {
            // KafkaConsumer.poll(final Duration timeout)   设置超时时间，拉的是一批数据，实现了Iterable接口
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            Thread.sleep(200);
            for (ConsumerRecord<String, String> record : records){
                // 从哪个主题里拉取出来
                logger.info("topic = {},value = {},offset = {},partition = {},key = {}", record.topic(), record.value(),record.offset(),record.partition(),record.key());
            }
        }
    }
}
