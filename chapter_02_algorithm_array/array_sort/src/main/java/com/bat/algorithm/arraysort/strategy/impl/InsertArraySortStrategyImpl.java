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
        for (int i = 1, len = unSortedArr.length; i < len; i++) {
            for (int j = i; j > 0; j--) {
                // 往前遍历直到找到小于等于自己的
                if (unSortedArr[j] < unSortedArr[j - 1]) {
                    arrayElementSwap(unSortedArr, j, j - 1);
                } else {
                    break;
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
