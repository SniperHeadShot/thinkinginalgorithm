package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

import java.util.Arrays;

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
            // 定义桶 [arr.length]
            int[][] elementHolder = new int[unSortedArr.length][0];

            // 取余获得位数并将其放在桶内
            for (int j = 0; j < unSortedArr.length; j++) {
                int pos = (unSortedArr[j]) / i % 10;
                elementHolder[pos] = arrayAppend(elementHolder[pos], unSortedArr[j]);
            }

            // 对桶里的元素从下往上进行回收
            int recycle = 0;
            for (int[] bucket : elementHolder) {
                for (int value : bucket) {
                    unSortedArr[recycle++] = value;
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
     * 将数组扩容并填入新值
     *
     * @param arr   数组
     * @param value 新值
     * @author ZhengYu
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
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
}
