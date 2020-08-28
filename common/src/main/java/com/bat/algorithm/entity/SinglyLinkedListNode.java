package com.bat.algorithm.entity;

/**
 * 单向链表节点
 *
 * @author ZhengYu
 * @version 1.0 2020/8/29 6:28
 **/
public class SinglyLinkedListNode<T> {

    private T value;

    private SinglyLinkedListNode<T> next;

    public SinglyLinkedListNode() {
    }

    public SinglyLinkedListNode(T value) {
        this.value = value;
    }

    public SinglyLinkedListNode(T value, SinglyLinkedListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }
}
