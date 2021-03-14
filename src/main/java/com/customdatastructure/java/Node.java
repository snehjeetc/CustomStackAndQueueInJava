package com.customdatastructure.java;

public class Node<K> implements INode<K> {
    private K key;
    private Node<K> next;
    public Node(K value){
        this.key = value;
        this.next = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public Node<K> getNext() {
        return next;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public void setNext(INode next) {
        this.next = (Node<K>) next;
    }

}