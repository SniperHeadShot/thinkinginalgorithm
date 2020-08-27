package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 计数排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/27 9:34
 **/
public class CountArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        // 寻找最大值
        int maxValue = findMax(unSortedArr);

        // 创建一个最大值+1长度的新数组，将未排序的数据放入，数据值为新数组下标，新数组的值为此位置元素的个数
        int[] newArr = new int[maxValue + 1];
        for (int element : unSortedArr) {
            newArr[element] = newArr[element] + 1;
        }

        // 遍历新数组按照计数将下标填入未排序数据
        int index = 0;
        for (int i = 0, len = newArr.length; i < len; i++) {
            for (int j = 0, count = newArr[i]; j < count; j++) {
                unSortedArr[index++] = i;
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
        return "计数排序";
    }
}
