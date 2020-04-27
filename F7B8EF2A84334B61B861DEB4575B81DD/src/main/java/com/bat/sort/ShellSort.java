package com.bat.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 希尔排序
 *
 * @author ZhengYu
 * @version 1.0 2020/4/28 6:58
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] sortArr = {6, 4322, 432, 344, 55, 55};
        shellSort(sortArr);
        System.out.println(JSONObject.toJSONString(sortArr));
    }

    private static void shellSort(int[] arrays) {
        for (int step = arrays.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arrays.length; i++) {
                int j = i;
                int temp = arrays[j];

                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
    }
}
