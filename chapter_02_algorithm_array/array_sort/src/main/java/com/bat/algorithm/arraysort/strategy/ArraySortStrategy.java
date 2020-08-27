package com.bat.algorithm.arraysort.strategy;

import java.util.Arrays;

/**
 * 策略模式 - 数组排序策略
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:10
 **/
public interface ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    void sort(int[] unSortedArr);

    /**
     * 策略名称
     *
     * @author ZhengYu
     */
    default String strategyName() {
        return this.getClass().getName();
    }

    /**
     * 数组下标对应元素值互换
     *
     * @param arr    数组
     * @param index1 下标1
     * @param index2 下标2
     * @author ZhengYu
     */
    default void arrayElementSwap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 将数组扩容并填入新值
     *
     * @param arr   数组
     * @param value 新值
     * @author ZhengYu
     */
    default int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * 获取数组的最大值
     *
     * @param arr 数组
     * @author ZhengYu
     */
    default int findMax(int[] arr) {
        int result = 0;
        for (int temp : arr) {
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
