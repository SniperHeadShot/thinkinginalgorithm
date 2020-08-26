package com.bat.algorithm.arraysort.strategy.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;

/**
 * 堆排序 实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/26 22:37
 **/
public class HeapArraySortStrategyImpl implements ArraySortStrategy {

    /**
     * 排序
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    @Override
    public void sort(int[] unSortedArr) {
        // 构造大顶堆
        buildMaxHeap(unSortedArr);

        //
        int size = unSortedArr.length;
        arrayElementSwap(unSortedArr, 0, --size);
        while (size > 0) {
            heapBeauty(unSortedArr, 0, size);
            arrayElementSwap(unSortedArr, 0, --size);
        }
    }

    /**
     * 构造大顶堆
     *
     * @param unSortedArr 待排序数组
     * @author ZhengYu
     */
    private void buildMaxHeap(int[] unSortedArr) {
        for (int i = 0, len = unSortedArr.length; i < len; i++) {
            // 新插入的索引
            int currentIndex = i;
            // 父索引
            int fatherIndex = (currentIndex - 1) / 2;

            while (unSortedArr[currentIndex] > unSortedArr[fatherIndex]) {
                // 因为是小顶堆，如果父节点值大于当前节点，则索引元素互换
                arrayElementSwap(unSortedArr, currentIndex, fatherIndex);

                // 父子索引重新赋值
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    /**
     * 堆化
     */
    public void heapBeauty(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            arrayElementSwap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 策略名称
     *
     * @author ZhengYu
     */
    @Override
    public String strategyName() {
        return "堆排序";
    }
}
