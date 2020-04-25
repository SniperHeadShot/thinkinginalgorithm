package com.bat.insert;

import com.alibaba.fastjson.JSONObject;

/**
 * 插入排序
 *
 * @author ZhengYu
 * @version 1.0 2020/4/25 15:01
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] sortArr = {6, 4322, 432, 344, 55, 55};
        insertSort(sortArr);
        System.out.println(JSONObject.toJSONString(sortArr));
    }

    private static void insertSort(int[] arrays) {
        int temp;
        for (int i = 1; i < arrays.length; i++) {
            temp = arrays[i];

            int j = i - 1;
            while (j >= 0 && arrays[j] > temp) {
                arrays[j + 1] = arrays[j];
                j--;
            }
            arrays[j + 1] = temp;
        }
    }
}
