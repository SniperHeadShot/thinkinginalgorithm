package com.bat.datastructure.binarysearch;

/**
 * 二叉搜索树测试主类
 *
 * @author ZhengYu
 * @version 1.0 2020/8/12 14:51
 **/
public class BinarySearchTestMain {
    public static void main(String[] args) {
        CustomBinarySearch<Integer> customBinarySearch = new CustomBinarySearch<>(Integer::compareTo);

        // 新增元素
        customBinarySearch.add(6);
        customBinarySearch.add(4);
        customBinarySearch.add(7);
        customBinarySearch.add(9);

        // 容器长度
        System.out.println(customBinarySearch.size());

        // 查找元素
        System.out.println(String.format("元素6是否存在于集合中: [%b]", customBinarySearch.contains(9)));
        System.out.println(String.format("元素5是否存在于集合中: [%b]", customBinarySearch.contains(5)));
    }
}
