package com.synway.sort.insertion;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * @Title: Insertion.java
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: 夜阑珊
 * @date: 2019/12/9 17:59
 * @version: v1.0
 * @Copyright (c): 2019 synway.com All rights reserved.
 */
public class Insertion {
    private static int[] datas = {6, 4, 5, 3, 8, 1};

    public static void main(String[] args) {
        System.out.println(JSONUtils.toJSONString(datas));
        insertionSort(datas);
        System.out.println(JSONUtils.toJSONString(datas));
    }

    private static void insertionSort(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            int preIndex = i - 1;
            int currentNode = arrs[i];
            while (preIndex >= 0 && arrs[preIndex] > currentNode) {
                arrs[preIndex + 1] = arrs[preIndex];
                preIndex--;
            }
            arrs[preIndex + 1] = currentNode;
        }
    }
}
