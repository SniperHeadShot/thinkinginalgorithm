package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 插入排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/14 13:24
 **/
public class InsertArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        for (int i = 0, len = unSortedArr.length; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (unSortedArr[i] > unSortedArr[j]) {
                    int temp = unSortedArr[i];
                    unSortedArr[i] = unSortedArr[j];
                    unSortedArr[j] = temp;
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
        return "插入排序";
    }
}
