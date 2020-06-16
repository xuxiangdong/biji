package com.synway.sort;

/**
 * @Title: Swap.java
 * @Description: 交换数据
 * @author: 夜阑珊
 * @date: 2019/12/9 17:16
 * @version: v1.0
 * @Copyright (c): 2019 synway.com All rights reserved.
 */
public class Swap {
    /**
     * 交换数据方法一
     *
     * @param arrs
     * @param i
     * @param j
     */
    public static void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    /**
     * 交换数据方法二
     *
     * @param arrs
     * @param i
     * @param j
     */
    public static void swap2(int[] arrs, int i, int j) {
        arrs[i] = arrs[i] + arrs[j];
        arrs[j] = arrs[i] - arrs[j];
        arrs[i] = arrs[i] - arrs[j];
    }

    /**
     * 交换数据方法三
     *
     * @param arrs
     * @param i
     * @param j
     */
    public static void swap3(int[] arrs, int i, int j) {

        arrs[i] = arrs[i] ^ arrs[j];
        arrs[j] = arrs[i] ^ arrs[j];
        arrs[i] = arrs[i] ^ arrs[j];
    }
}
