package com.project;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: Rrow
 * @date: 2022/1/28 22:34
 */
public class TestParameter {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = TestParameter.class.getClassLoader().getResourceAsStream("PARAMETER.properties");
        properties.load(resourceAsStream);
        String THREAD_NUM = properties.getProperty("THREAD_NUM");
        System.out.println(THREAD_NUM);
    }
}
