package com.bat.selection;

import com.alibaba.fastjson.JSONObject;

/**
 * 选择排序
 *
 * @author ZhengYu
 * @version 1.0 2020/4/25 14:16
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] sortArr = {6, 4322, 432, 344, 55, 55};
        selectionSort(sortArr);
        System.out.println(JSONObject.toJSONString(sortArr));
    }

    private static void selectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            // 每轮获取最大值及其下标
            int maxIndex = 0;
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[j] > arrays[maxIndex]) {
                    maxIndex = j;
                }
            }

            // 每轮的最后一位和最大值交换位置
            int temp = arrays[arrays.length - i - 1];
            arrays[arrays.length - i - 1] = arrays[maxIndex];
            arrays[maxIndex] = temp;
        }
    }
}
