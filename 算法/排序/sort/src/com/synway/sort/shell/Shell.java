package com.synway.sort.shell;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.net.HostAndPort;
import com.google.common.net.InetAddresses;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @Title: Shell.java
 * @Description: 希尔排序
 * @author: 夜阑珊
 * @date: 2019/12/9 18:35
 * @version: v1.0
 * @Copyright (c): 2019 synway.com All rights reserved.
 */
public class Shell {
    private static int[] datas = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};

    public static void main2(String[] args) {
        System.out.println(JSONUtils.toJSONString(datas));
        shellSort(datas);
        System.out.println(JSONUtils.toJSONString(datas));
    }

    public static void main(String[] args) {
        int N = 10;
        int h = 1;
        while (h < N / 3) {
            // h 1 4 12
            h = 3 * h + 1;
        }
    }
    public static void main3(String[] args) {
        System.out.println();
        int len = datas.length;
        int gap = 1;
        // 动态定义间隔序列，按gap * 3 + 1得到增量序列的最大值
        while (gap < len / 3) {
            for (int i = gap; i < len; i++) {
                for (int k = i; k < len; k = k + gap) {
                    if (datas[k] < datas[k - gap]) {
                        System.out.println("i="+i+"k="+k);
                    }
                }
            }
            System.out.println(gap);
            gap = gap * 3 + 1;
        }
        System.out.println("=============");
        while (gap > 0) {
            gap = (gap - 1) / 3;
            System.out.println(gap);
        }
    }

    private static void shellSort(int[] arrs) {
        //首先根据数组长度确定增量的最大值
        int len = arrs.length;
        int gap = 1;
        // 动态定义间隔序列，按gap * 3 + 1得到增量序列的最大值
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        //进行增量查找和排序
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                for (int k = i; k < len; k = k + gap) {
                    //判断是否需要重新排序，如果小于k-gap处的值，需要重新排序
                    if (arrs[k] < arrs[k - gap]) {
                        int temp = arrs[k];
                        int j = k;
                        for (; j >= i && temp < arrs[j - gap]; j -= gap) {
                            arrs[j] = arrs[j - gap];
                            System.out.println(ArrayUtils.toString(arrs));
                        }
                        arrs[j] = temp;
                    }
                }
            }
            gap = (gap - 1) / 3;
        }
    }
}
