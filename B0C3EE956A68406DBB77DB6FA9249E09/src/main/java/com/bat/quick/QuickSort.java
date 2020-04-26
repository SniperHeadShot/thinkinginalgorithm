package com.bat.quick;

import com.alibaba.fastjson.JSONObject;

/**
 * 快速排序
 *
 * @author ZhengYu
 * @version 1.0 2020/4/26 8:55
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] sortArr = {6, 4322, 432, 344, 55, 55};
        quickSort(sortArr, 0, sortArr.length - 1);
        System.out.println(JSONObject.toJSONString(sortArr));
    }

    /**
     * 快速排序
     *
     * @param arrays 待排序数组
     * @param L      左边界下标
     * @param R      右边界下标
     * @author ZhengYu
     */
    private static void quickSort(int[] arrays, int L, int R) {
        int i = L, j = R;

        int pivot = arrays[(L + R) / 2];

        // 左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            // 寻找直到找到比支点大的数
            while (pivot > arrays[i]) {
                i++;
            }

            // 寻找直到找到比支点小的数
            while (pivot < arrays[j]) {
                j--;
            }

            // 此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
                i++;
                j--;
            }
        }
        // 上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了

        // "左边"再做排序，直到左边剩下一个数(递归出口)
        if (L < j) {
            quickSort(arrays, L, j);
        }

        // "右边"再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {
            quickSort(arrays, i, R);
        }
    }
}
