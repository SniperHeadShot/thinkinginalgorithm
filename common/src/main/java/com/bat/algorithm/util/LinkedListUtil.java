package com.bat.algorithm.util;

import com.bat.algorithm.entity.SinglyLinkedListNode;

/**
 * 链表工具类
 *
 * @author ZhengYu
 * @version 1.0 2020/8/29 6:27
 **/
public class LinkedListUtil {

    /**
     * 递增生成一个单链表
     *
     * @author ZhengYu
     */
    public static SinglyLinkedListNode<Integer> initSinglyLinkedList(Integer capacity) {
        SinglyLinkedListNode<Integer> headNode = null;
        SinglyLinkedListNode<Integer> prevNode = null;
        SinglyLinkedListNode<Integer> temp = null;
        for (int i = 0; i < capacity; i++) {
            if (prevNode == null) {
                prevNode = headNode = new SinglyLinkedListNode<>(i);
            } else {
                temp = new SinglyLinkedListNode<>(i);
                prevNode.setNext(temp);
                prevNode = temp;
            }
        }
        return headNode;
    }


    /**
     * 遍历单链表
     *
     * @param node 头节点
     * @author ZhengYu
     */
    public static <T> void traversePrintSinglyLinkedList(SinglyLinkedListNode<T> node) {
        do {
            if (node == null) {
                return;
            }
            System.out.println(node.getValue().toString());
            node = node.getNext();
        } while (node != null);
    }
}
