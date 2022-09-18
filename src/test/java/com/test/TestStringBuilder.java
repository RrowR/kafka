package com.test;

import org.junit.jupiter.api.Test;

/**
 * @Author Rrow
 * @Date 2022/8/17 14:36
 */
public class TestStringBuilder {
    @Test
    public void Test01() {
        StringBuilder stringBuilder = new StringBuilder();
    }

    @Test
    public void Test02() {
        int ceil = (int) Math.ceil(22.1);
        System.out.println(ceil);
    }

    @Test
    public void Test03() {
        String usedPercent = (int) Math.ceil(((1000 / 1024.0) * 100)) + "%";
        System.out.println("usedPercent = " + usedPercent);
    }

    @Test
    public void Test04() {
        System.out.println("Math.ceil(((1000.0 / 1024) * 100)) = " + Math.ceil(((1000.0 / 1024) * 100)));
    }
}
