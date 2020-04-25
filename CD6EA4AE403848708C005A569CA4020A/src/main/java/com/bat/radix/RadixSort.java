package com.bat.radix;

import com.alibaba.fastjson.JSONObject;

/**
 * 基数排序
 *
 * @author ZhengYu
 * @version 1.0 2020/4/24 9:38
 **/
public class RadixSort {
    public static void main(String[] args) {
        int max = 4322;
        int[] sortArr = {6, 4322, 432, 344, 55, 55};
        radixSort(sortArr, max);
        System.out.println(JSONObject.toJSONString(sortArr));
    }

    /**
     * 基数排序
     *
     * @param arrays 待排序的数组
     * @param max    最大值
     * @author ZhengYu
     */
    private static void radixSort(int[] arrays, int max) {
        // 根据最大值确定循环的次数
        for (int i = 1; max / i > 0; i *= 10) {

            // 定义桶([arrays.length][0~9])
            int[][] buckets = new int[arrays.length][10];

            // 取余获得位数并将其放在桶内
            for (int j = 0; j < arrays.length; j++) {
                int num = (arrays[j] / i) % 10;
                buckets[j][num] = arrays[j];
            }

            // 对桶里的元素进行回收
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < arrays.length; l++) {
                    if (buckets[l][j] != 0) {
                        arrays[k++] = buckets[l][j];
                    }
                }
            }
        }
    }
}
