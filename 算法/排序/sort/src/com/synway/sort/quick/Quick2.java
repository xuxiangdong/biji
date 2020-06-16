package com.synway.sort.quick;

import com.alibaba.druid.support.json.JSONUtils;
import com.synway.sort.Swap;

/**
 * @Title: Quick2.java
 * @Description: 快速排序算法
 * @author: 夜阑珊
 * @date: 2019/12/11 9:34
 * @version: v1.0
 * @Copyright (c): 2019 synway.com All rights reserved.
 */
public class Quick2 {

    private static int[] datas = {2, 6, 4, 5, 3, 8, 1};

    public static void main(String[] args) {
        System.out.println(JSONUtils.toJSONString(datas));
        quickSort(datas, 0, datas.length - 1);
        System.out.println(JSONUtils.toJSONString(datas));
    }

    public static void quickSort(int[] arrs, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(arrs, left, right);
        quickSort(arrs, left, index - 1);
        quickSort(arrs, index + 1, right);
    }

    public static int partition(int[] arrs, int left, int right) {
        int keyValue = arrs[left];
        int key = left;
        while (left < right) {
            //从右边开始找第一个比基准数小的元素
            while (left < right && arrs[right] >= keyValue) {
                right--;
            }
            //从左边开始找第一个比基准数大的元素
            while (left < right && arrs[left] <= keyValue) {
                left++;
            }
            //交换这2个元素
            Swap.swap(arrs, left, right);
        }
        //将基准元素放在
        Swap.swap(arrs, key, left);
        return left;
    }

}
