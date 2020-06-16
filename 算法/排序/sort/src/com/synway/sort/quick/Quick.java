package com.synway.sort.quick;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * @Title: Quick.java
 * @Description: 快速排序算法
 * @author: 夜阑珊
 * @date: 2019/12/10 9:35
 * @version: v1.0
 * @Copyright (c): 2019 synway.com All rights reserved.
 */
public class Quick {
    private static int[] datas = {2, 6, 4, 5, 3, 8, 1};

    public static void main(String[] args) {
        System.out.println(JSONUtils.toJSONString(datas));
        quickSort(datas, 0, datas.length - 1);
        System.out.println(JSONUtils.toJSONString(datas));
    }

    private static void quickSort(int[] arrs, int left, int right) {
        if (left < right) {
            int middle = getMiddle(arrs, left, right);
            quickSort(arrs, 0, middle - 1);
            quickSort(arrs, middle + 1, right);
        }
    }

    /**
     * 进行一次具体的快速排序算法
     *
     * @param arrs
     * @param left
     * @param right
     */
    private static int getMiddle(int[] arrs, int left, int right) {
        int temp = arrs[left];//基准元素
        while (left < right) {
            //从右边开始找第一个比基准元素小的元素位置
            while (left < right && arrs[right] >= temp) {
                right--;
            }
            arrs[left] = arrs[right];
            //从左边开始找第一个比基准元素大的元素
            while (left < right && arrs[left] <= temp) {
                left++;
            }
            arrs[right] = arrs[left];
        }
        arrs[left] = temp;
        return left;
    }
}
