package com.synway.sort.bubble;

import com.alibaba.druid.support.json.JSONUtils;
import com.synway.sort.Swap;

/**
 * @Title: Bubble.java
 * @Description: 冒泡排序
 * @author: 夜阑珊
 * @date: 2019/12/9 14:41
 * @version: v1.0
 * @Copyright (c): 2019 synway.com All rights reserved.
 */
public class Bubble {
    /**
     * 待排序数组
     */
    private static int[] datas = {6, 4, 5, 3, 8, 1};

    public static void main(String[] args) {
        System.out.println(JSONUtils.toJSONString(datas));
        bubbleSort2(datas);
        System.out.println(JSONUtils.toJSONString(datas));
    }

    /**
     * 冒泡排序 <br />
     * 实现方式一 <br />
     *
     * @param: <br />
     * @return: <br />
     * @createDate 2019/12/9 15:57 <br />
     * @author: 夜阑珊 <br />
     * @see [类、类#方法、类#成员]
     */
    private static void bubbleSort(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - 1 - i; j++) {//这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if (arrs[j] > arrs[j + 1]) {
                    Swap.swap(arrs, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序 <br />
     * 实现方式二 <br />
     *
     * @param: <br />
     * @return: <br />
     * @createDate 2019/12/9 15:57 <br />
     * @author: 夜阑珊 <br />
     * @see [类、类#方法、类#成员]
     */
    private static void bubbleSort2(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = arrs.length - 1; j > i; j--) {
                if (arrs[j] < arrs[j - 1]) {
                    Swap.swap3(arrs, j - 1, j);
                }
            }
        }
    }


}
