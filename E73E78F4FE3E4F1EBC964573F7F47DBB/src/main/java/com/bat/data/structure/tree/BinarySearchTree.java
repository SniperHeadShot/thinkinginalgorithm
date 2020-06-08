package com.bat.data.structure.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 二叉查找树 示例
 *
 * @author ZhengYu
 * @version 1.0 2020/6/3 11:41
 **/
public class BinarySearchTree<K extends Comparable<K>, V> {

    // 根节点
    private Node root;

    @Data
    private class Node {
        // 可排序的键
        private K key;

        // 实际存储的值
        private V value;

        // 左子树和右子树
        private Node left, right;

        // 以该节点为根的子树中的节点个数
        private int counter;

        Node(K key, V value, int counter) {
            this.key = key;
            this.value = value;
            this.counter = counter;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.counter;
        }
    }

    /**
     * 查
     *
     * @param key 键
     * @return V
     * @author ZhengYu
     */
    public V get(K key) {
        return get(root, key);
    }

    /**
     * 递归查
     *
     * @param node 节点
     * @param key  键
     * @return V
     * @author ZhengYu
     */
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compare = node.key.compareTo(key);
        if (compare > 0) {
            return get(node.left, key);
        } else if (compare < 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    /**
     * 增
     *
     * @param key   键
     * @param value 值
     * @author ZhengYu
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * 递归增
     *
     * @param node  节点
     * @param key   键
     * @param value 值
     * @return V
     * @author ZhengYu
     */
    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compare = node.key.compareTo(key);
        if (compare > 0) {
            node.left = put(node.left, key, value);
        } else if (compare < 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.counter = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(K key) {

    }

    private void delete(Node node, K key) {
        if (node == null) {
            return;
        }
        int compare = node.key.compareTo(key);
        if (compare > 0) {


            delete(node.left, key);
        } else if (compare < 0) {
            delete(node.right, key);
        } else {

        }
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(root);
    }
}
