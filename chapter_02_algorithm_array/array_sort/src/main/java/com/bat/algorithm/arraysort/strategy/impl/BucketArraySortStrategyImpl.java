package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 桶排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/27 9:28
 **/
public class BucketArraySortStrategyImpl implements ArraySortStrategy {

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
            int[][] bucket = new int[unSortedArr.length][0];

            // 取余获得位数并将其放在桶内
            for (int element : unSortedArr) {
                int pos = (element) / i % 10;
                bucket[pos] = arrayAppend(bucket[pos], element);
            }

            // 对桶里的元素从下往上进行回收
            int index = 0;
            for (int[] element : bucket) {
                for (int value : element) {
                    unSortedArr[index++] = value;
                }
            }
        }
    }

    /**
     * 策略名称
     *
     * @author ZhengYu
     */
    @Override
    public String strategyName() {
        return "桶排序";
    }
}
