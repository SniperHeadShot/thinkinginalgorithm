package com.bat.algorithm.arraysort.template;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;
import com.bat.algorithm.util.InitialRandomNumberCreateUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 模板模式 - 数组排序展示模板
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:22
 **/
public abstract class ArraySortDisplayTemplate {

    /**
     * 模板方法
     * step1: 加载排序策略
     * step1: 遍历策略，每个策略生成新的待排序数组然后排序
     *
     * @author ZhengYu
     */
    public void display() {
        List<ArraySortStrategy> arraySortStrategyList = loadArraySortStrategyList();
        if (arraySortStrategyList == null || arraySortStrategyList.isEmpty()) {
            System.out.println("未加载到任何排序策略, 处理结束!");
            return;
        }
        arraySortStrategyList.forEach(arraySortStrategy -> {
            System.out.println(String.format(">>> %s", arraySortStrategy.strategyName()));
            int[] unSortedArr = buildRandomLenIntArr();
            System.out.println(String.format("排序前: [%s]", print(unSortedArr)));
            long beginMillis = System.currentTimeMillis();
            arraySortStrategy.sort(unSortedArr);
            long endMillis = System.currentTimeMillis();
            System.out.println(String.format("排序后: [%s], 耗时: [%d]ms", print(unSortedArr), endMillis - beginMillis));
            System.out.println(String.format("排序结果检查: [%b]", veritySortResult(unSortedArr)));
        });
    }

    /**
     * 加载排序策略
     *
     * @author ZhengYu
     */
    protected abstract List<ArraySortStrategy> loadArraySortStrategyList();

    /**
     * 初始化一个未排序的数组
     *
     * @author ZhengYu
     */
    protected int[] buildRandomLenIntArr() {
        return InitialRandomNumberCreateUtil.buildRandomLenIntArr(2000);
    }

    /**
     * 检查排序结果是否正确
     *
     * @author ZhengYu
     */
    protected boolean veritySortResult(int[] arr) {
        boolean result = true;
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 打印数组
     *
     * @param arr 数组
     * @author ZhengYu
     */
    protected String print(int[] arr) {
        if (arr.length > 1000) {
            return "" + arr.length;
        }
        return Arrays.toString(arr);
    }
}
