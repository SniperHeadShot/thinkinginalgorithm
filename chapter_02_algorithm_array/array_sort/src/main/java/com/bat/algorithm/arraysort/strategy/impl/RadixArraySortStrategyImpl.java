package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 基数排序
 *
 * @author ZhengYu
 * @version 1.0 2020/8/17 10:02
 **/
public class RadixArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        // 找到最大值用来确定循环次数
        int max = findMax(unSortedArr);
        for (int i = 1; max / i > 0; i *= 10) {
            // 定义桶([arr.length][0~9])
            int[][] bucket = new int[unSortedArr.length][10];

            // 取余获得位数并将其放在桶内
            for (int j = 0; j < unSortedArr.length; j++) {
                bucket[j][unSortedArr[j] / i % 10] = unSortedArr[j];
            }

            // 对桶里的元素进行回收, 每次回收后按位数有序
            int recycle = 0;
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < unSortedArr.length; j++) {
                    if (bucket[j][k] != 0) {
                        unSortedArr[recycle++] = bucket[j][k];
                    }
                }
            }
        }
    }

    private int findMax(int[] arr) {
        int result = 0;
        for (int temp : arr) {
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    /**
     * 策略名称
     *
     * @author ZhengYu
     */
    @Override
    public String strategyName() {
        return "基数排序";
    }

    public static void main(String[] args) {
        System.out.println(1115 / 10);
        System.out.println(1115 / 100);
        System.out.println(1115 / 1000);
    }
}
