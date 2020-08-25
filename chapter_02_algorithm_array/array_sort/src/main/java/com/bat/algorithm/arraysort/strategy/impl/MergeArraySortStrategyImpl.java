package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

import java.util.Arrays;

/**
 * 归并排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/21 13:19
 **/
public class MergeArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        int[] temp = divideArr(unSortedArr);
        System.arraycopy(temp, 0, unSortedArr, 0, unSortedArr.length);
    }

    private int[] divideArr(int[] unSortedArr) {
        if (unSortedArr.length < 2) {
            return unSortedArr;
        }

        int middle = unSortedArr.length / 2;

        int[] left = Arrays.copyOfRange(unSortedArr, 0, middle);
        int[] right = Arrays.copyOfRange(unSortedArr, middle, unSortedArr.length);

        return merge(divideArr(left), divideArr(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int l = 0, r = 0, index = 0, lenL = left.length, lenR = right.length;
        for (; l < lenL && r < lenR; ) {
            if (left[l] <= right[r]) {
                result[index] = left[l];
                l++;
            } else {
                result[index] = right[r];
                r++;
            }
            index++;
        }

        // 左侧先满, 右侧未满
        if (l == lenL && r < lenR) {
            System.arraycopy(right, r, result, index, lenR - r);
        }

        // 左侧未满, 右侧先满
        if (r == lenR && l < lenL) {
            System.arraycopy(left, l, result, index, lenL - l);
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
        return "归并排序";
    }
}
