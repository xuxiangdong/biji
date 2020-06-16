package com.synway.sort.selection;

import com.alibaba.druid.support.json.JSONUtils;
import com.synway.sort.Swap;

/**
 * @Title: 选择排序
 * @Description: 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @author: 夜阑珊
 * @date: 2019/12/9 17:05
 * @version: v1.0
 * @Copyright (c): 2019 synway.com All rights reserved.
 */
public class Selection {
    private static int[] datas = {6, 4, 5, 3, 8, 1};

    public static void main(String[] args) {
        System.out.println(JSONUtils.toJSONString(datas));
        selectionSort(datas);
        System.out.println(JSONUtils.toJSONString(datas));
    }

    private static void selectionSort(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    Swap.swap(arrs, i, j);
                }
            }
        }
    }
}
