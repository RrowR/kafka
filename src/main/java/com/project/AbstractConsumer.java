package com.project;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Rrow
 * @date: 2022/1/28 22:50
 */
public abstract class AbstractConsumer {
    protected Integer QUEUE_SIZE;
    protected LinkedBlockingQueue<String> dbQueue;
    {
        Properties properties = new Properties();
        InputStream resourceAsStream = AbstractConsumer.class.getClassLoader().getResourceAsStream("PARAMETER.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println("加载文件出现错误");
        }
        QUEUE_SIZE = Integer.valueOf(properties.getProperty("QUEUE_SIZE"));
        dbQueue = new LinkedBlockingQueue<>(QUEUE_SIZE);
    }


}
