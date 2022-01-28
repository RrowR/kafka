package com.project;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Rrow
 * @date: 2022/1/28 22:58
 */
public class TestMain {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        LinkedBlockingQueue<String> dbQueue = consumer.dbQueue;
        System.out.println("dbQueue.offer(\"1\") = " + dbQueue.offer("1"));
        System.out.println("dbQueue.offer(\"2\") = " + dbQueue.offer("2"));

    }
}
