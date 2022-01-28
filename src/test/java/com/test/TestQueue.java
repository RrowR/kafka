package com.test;


import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * atlan 2022/1/27 21:09
 */
public class TestQueue {
    @Test
    void Test01() throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(1);
        downLatch.await();
    }

    /**
     * take阻塞式移除
     * put阻塞式添加
     * @throws InterruptedException
     */
    @Test
    void Test02() throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue<>(2);
        queue.offer("1");
        queue.offer("2");
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
