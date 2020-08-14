package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 冒泡排序实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:15
 **/
public class BubbleArraySortStrategyImpl implements ArraySortStrategy {

    @Override
    public void sort(int[] unSortedArr) {
        for (int i = 0, len = unSortedArr.length; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (unSortedArr[j] > unSortedArr[j + 1]) {
                    int temp = unSortedArr[j + 1];
                    unSortedArr[j + 1] = unSortedArr[j];
                    unSortedArr[j] = temp;
                }
            }
        }
    }

    @Override
    public String strategyName() {
        return "冒泡排序";
    }
}
