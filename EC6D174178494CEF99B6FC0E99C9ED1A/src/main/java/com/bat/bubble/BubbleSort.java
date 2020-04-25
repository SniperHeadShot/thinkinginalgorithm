package com.bat.bubble;

import com.alibaba.fastjson.JSONObject;

/**
 * 冒泡排序
 *
 * @author ZhengYu
 * @version 1.0 2020/4/25 13:53
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] sortArr = {6, 4322, 432, 344, 55, 55};
        bubbleSort(sortArr);
        System.out.println(JSONObject.toJSONString(sortArr));
    }

    private static void bubbleSort(int[] arrays) {
        int temp;
        // 冒泡排序优化: 如果在某躺排序中没有发生交换位置，那么我们可以认为该数组已经排好序了
        boolean changeFlag = false;

        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;

                    changeFlag = true;
                }
            }

            if (changeFlag) {
                break;
            }
        }
    }
}
