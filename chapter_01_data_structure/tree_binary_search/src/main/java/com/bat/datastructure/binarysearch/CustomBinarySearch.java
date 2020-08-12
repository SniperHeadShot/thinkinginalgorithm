package com.bat.datastructure.binarysearch;

import java.util.Comparator;

/**
 * 基于二查搜索树特性设计的容器
 *
 * @author ZhengYu
 * @version 1.0 2020/8/12 14:54
 **/
public class CustomBinarySearch<T> {

    private Node root;

    private Comparator<T> comparator;

    public CustomBinarySearch(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * 获取集合长度
     *
     * @author ZhengYu
     */
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.childNodeCount + 1;
    }

    /**
     * 是否包含元素
     *
     * @author ZhengYu
     */
    public boolean contains(T o) {
        if (o == null || root == null) {
            return false;
        }
        return recursionFindValue(root, o);
    }

    private boolean recursionFindValue(Node node, T e) {
        int compare = comparator.compare(node.value, e);
        if (compare > 0) {
            if (node.left == null) {
                return false;
            }
            return recursionFindValue(node.left, e);
        } else if (compare < 0) {
            if (node.right == null) {
                return false;
            }
            return recursionFindValue(node.right, e);
        } else {
            return true;
        }
    }

    /**
     * 添加元素
     *
     * @param e 待添加元素
     * @author ZhengYu
     */
    public boolean add(T e) {
        if (root == null) {
            root = new Node(e, 0);
            root.value = e;
            return true;
        }
        return recursionAddValue(root, e);
    }

    private boolean recursionAddValue(Node node, T e) {
        int compare = comparator.compare(node.value, e);
        if (compare > 0) {
            if (node.left == null) {
                node.left = new Node(e, 0);
                node.childNodeCount = node.childNodeCount + 1;
                return true;
            } else {
                boolean result = recursionAddValue(node.left, e);
                if (result) {
                    node.childNodeCount = node.childNodeCount + 1;
                }
                return result;
            }
        } else if (compare < 0) {
            if (node.right == null) {
                node.right = new Node(e, 0);
                node.childNodeCount = node.childNodeCount + 1;
                return true;
            } else {
                boolean result = recursionAddValue(node.right, e);
                if (result) {
                    node.childNodeCount = node.childNodeCount + 1;
                }
                return result;
            }
        } else {
            return false;
        }
    }

    /**
     * TODO 移除元素
     *
     * @param e 待移除元素
     * @author ZhengYu
     */
    public boolean remove(T e) {
        return false;
    }

    private class Node {

        // 值
        private T value;

        // 左节点
        private Node left;

        // 右节点
        private Node right;

        // 子节点数量
        private int childNodeCount;

        public Node(T value, int childNodeCount) {
            this.value = value;
            this.childNodeCount = childNodeCount;
        }
    }
}
