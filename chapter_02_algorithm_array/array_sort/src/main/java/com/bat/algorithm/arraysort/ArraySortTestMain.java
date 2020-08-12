package com.bat.algorithm.arraysort;

import com.bat.algorithm.arraysort.template.ArraySortDisplayTemplate;
import com.bat.algorithm.arraysort.template.impl.GeneralArraySortDisplayTemplateImpl;

/**
 * 数组排序 测试主类
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:03
 **/
public class ArraySortTestMain {
    public static void main(String[] args) {
        ArraySortDisplayTemplate arraySortDisplayTemplate = new GeneralArraySortDisplayTemplateImpl();
        arraySortDisplayTemplate.display();
    }
}
