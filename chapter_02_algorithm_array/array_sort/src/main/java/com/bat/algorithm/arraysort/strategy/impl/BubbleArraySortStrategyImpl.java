package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 冒泡排序实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:15
 **/
public class BubbleArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        // 共循环 len-1 轮
        for (int i = 0, len = unSortedArr.length; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                // 最大值上浮
                if (unSortedArr[j] > unSortedArr[j + 1]) {
                    arrayElementSwap(unSortedArr, j, j + 1);
                }
            }
        }
    }

    @Override
    public String strategyName() {
        return "冒泡排序";
    }
}
