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
        if (L == R) {
            return;
        }

        int M = (L + R) / 2;

        mergeSort(arrays, L, M);

        mergeSort(arrays, M + 1, R);

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
    public static void merge(int[] arrays, int L, int M, int R) {
        int[] leftArray = new int[M - L];
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        int[] rightArray = new int[R - M + 1];
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
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
