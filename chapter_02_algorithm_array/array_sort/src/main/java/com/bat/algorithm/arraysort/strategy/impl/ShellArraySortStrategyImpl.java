package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 希尔排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/21 13:20
 **/
public class ShellArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        // 计算增量
        int len = unSortedArr.length;
        int gap = calculateGap(len);

        // 跳跃数组排序
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                int j = i;
                while (j < len - gap) {
                    if (unSortedArr[j] > unSortedArr[j + gap]) {
                        // 这里使用插入排序对跳跃数组排序
                        for (int k = j + gap; k - gap >= 0; k -= gap) {
                            if (unSortedArr[k] < unSortedArr[k - gap]) {
                                arrayElementSwap(unSortedArr, k, k - gap);
                            } else {
                                break;
                            }
                        }
                    }
                    j += gap;
                }
            }
            gap = gap / 3;
        }
    }

    /**
     * 计算增量
     *
     * @param arrLen 数组长度
     * @author ZhengYu
     */
    public int calculateGap(int arrLen) {
        int gap = 1;
        while (gap < arrLen / 3) {
            gap = gap * 3 + 1;
        }
        return gap;
    }


    /**
     * 策略名称
     *
     * @author ZhengYu
     */
    @Override
    public String strategyName() {
        return "希尔排序";
    }
}
