package com.test;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: Rrow
 * @Date: 2022/1/28 9:25 上午
 */
public class TestMain {
    @Test
    void TestExecutors() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
        Future future = null;
        for (int i = 0; i < 10; i++) {
            final int j = i;
            Runnable runnable = () -> System.out.println(j);
            future = fixedThreadPool.submit(runnable);
            if (future.isDone()) {
                System.out.println("任务完成");
            }else {
                System.out.println("任务没完成");
            }
        }

    }

    @Test
    void Test02(){
        System.out.println("new Date().getTime() = " + new Date().getTime());
        new Thread(() -> {
            new Thread(() -> {
                System.out.println("线程里的任务执行了");
            }).start();
        }).start();
    }

    @Test
    void Test03(){
        String str = "sada/s@wq,eqeqw,qeqqqq";
        str = str.replace(",",".");
        System.out.println(str);
    }
}
