package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 选择排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/20 21:18
 **/
public class SelectArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        for (int i = 0, len = unSortedArr.length; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (unSortedArr[j] < unSortedArr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arrayElementSwap(unSortedArr, minIndex, i);
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
        return "选择排序";
    }
}
