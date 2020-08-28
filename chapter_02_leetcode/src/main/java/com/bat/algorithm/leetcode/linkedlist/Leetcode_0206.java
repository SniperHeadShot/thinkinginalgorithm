package com.bat.algorithm.leetcode.linkedlist;

import com.bat.algorithm.entity.SinglyLinkedListNode;
import com.bat.algorithm.util.LinkedListUtil;

/**
 * //反转一个单链表。
 * //
 * // 示例:
 * //
 * // 输入: 1->2->3->4->5->NULL
 * //输出: 5->4->3->2->1->NULL
 * //
 * // 进阶:
 * //你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * // Related Topics 链表
 *
 * @author ZhengYu
 * @version 1.0 2020/8/29 6:18
 **/
public class Leetcode_0206 {
    public static void main(String[] args) {
        // 方式1 - 迭代
        SinglyLinkedListNode<Integer> headNode1 = LinkedListUtil.initSinglyLinkedList(5);
        System.out.println("方式1 - 迭代 反转前 ==============");
        LinkedListUtil.traversePrintSinglyLinkedList(headNode1);

        headNode1 = reversalLinkedListByTraverse(headNode1);

        System.out.println("方式1 - 迭代 反转后 ==============");
        LinkedListUtil.traversePrintSinglyLinkedList(headNode1);

        // 方式2 - 递归
        SinglyLinkedListNode<Integer> headNode2 = LinkedListUtil.initSinglyLinkedList(5);
        System.out.println("方式2 - 递归 反转前 ==============");
        LinkedListUtil.traversePrintSinglyLinkedList(headNode2);

        headNode2 = reversalLinkedListByRecursion(headNode2);

        System.out.println("方式2 - 递归 反转后 ==============");
        LinkedListUtil.traversePrintSinglyLinkedList(headNode2);
    }

    private static <T> SinglyLinkedListNode<T> reversalLinkedListByTraverse(SinglyLinkedListNode<T> head) {
        SinglyLinkedListNode<T> prev = null;
        SinglyLinkedListNode<T> current = head;
        SinglyLinkedListNode<T> temp = null;
        do {
            if (current == null) {
                break;
            }
            temp = current.getNext();

            current.setNext(prev);

            prev = current;
            head = current;
            current = temp;
        } while (current != null);
        return head;
    }

    private static <T> SinglyLinkedListNode<T> reversalLinkedListByRecursion(SinglyLinkedListNode<T> head) {
        return reversalLinkedListByRecursion(null, head);
    }

    private static <T> SinglyLinkedListNode<T> reversalLinkedListByRecursion(SinglyLinkedListNode<T> prev, SinglyLinkedListNode<T> current) {
        if (current == null) {
            return null;
        }
        SinglyLinkedListNode<T> currentNext = current.getNext();
        current.setNext(prev);
        if (currentNext == null) {
            return current;
        } else {
            return reversalLinkedListByRecursion(current, currentNext);
        }
    }
}
