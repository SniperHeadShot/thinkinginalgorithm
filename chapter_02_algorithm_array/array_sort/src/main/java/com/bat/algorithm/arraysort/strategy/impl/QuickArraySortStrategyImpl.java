package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 快速排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/25 23:46
 **/
public class QuickArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        quickSort(unSortedArr, 0, unSortedArr.length - 1);
    }

    private void quickSort(int[] unSortedArr, int left, int right) {
        int i = left, j = right, pivot = unSortedArr[i];
        while (j > i) {
            // 先从右往左找第一个小于pivot(基准)的下标
            while (j > i && unSortedArr[j] >= pivot) {
                j--;
            }
            if (unSortedArr[j] <= pivot) {
                arrayElementSwap(unSortedArr, i, j);
            }
            // 从左往右找第一个大于基准的下标
            while (j > i && unSortedArr[i] <= pivot) {
                i++;
            }
            if (unSortedArr[i] > pivot) {
                arrayElementSwap(unSortedArr, i, j);
            }
        }

        // 此时第一轮循环比较结束，基准左边的值都比基准小，基准右边的值都比基准大

        if (i > left) {
            quickSort(unSortedArr, left, i - 1);
        }
        if (j < right) {
            quickSort(unSortedArr, j + 1, right);
        }
    }

    /**
     * 策略名称
     *
     * @author ZhengYu
     */
    @Override
    public String strategyName() {
        return "快速排序";
    }
}
