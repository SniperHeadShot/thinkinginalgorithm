package com.bat.merge;

import com.alibaba.fastjson.JSONObject;

/**
 * 归并排序
 *
 * @author ZhengYu
 * @version 1.0 2020/4/27 6:11
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] sortArr = {6, 4322, 432, 344, 55, 55};
        mergeSort(sortArr, 0, sortArr.length - 1);
        System.out.println(JSONObject.toJSONString(sortArr));
    }

    private static void mergeSort(int[] arrays, int L, int R) {
        // 递归的结束条件: 只有一个元素时结束递归
        if (L == R) {
            return;
        }

        // 将边界的元素分成两份用作归并算法
        int M = (L + R) / 2;

        // 分隔左边的元素直至弹栈
        mergeSort(arrays, L, M);

        // 分隔右边的元素直至弹栈
        mergeSort(arrays, M + 1, R);

        // 弹栈执行的动作, 将排好序的两个数组做归并处理
        merge(arrays, L, M + 1, R);
    }

    /**
     * 将数组分隔开的两部分合并起来
     *
     * @param arrays 待排序数组
     * @param L      左边界
     * @param M      分隔的元素
     * @param R      右边界
     * @author ZhengYu
     */
    private static void merge(int[] arrays, int L, int M, int R) {
        int[] leftArray = new int[M - L];
        if (M - L >= 0) {
            System.arraycopy(arrays, L, leftArray, 0, M - L);
        }
        int[] rightArray = new int[R - M + 1];
        if (R + 1 - M >= 0) {
            System.arraycopy(arrays, M, rightArray, 0, R + 1 - M);
        }

        int i = 0, j = 0;
        int k = L;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];
                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            arrays[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
