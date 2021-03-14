package com.customdatastructure.java;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class CustomLinkedList<T> {
    private INode<T> head;
    private INode<T> tail;
    private Integer size;

    public CustomLinkedList(T ...value ){
        if(value == null || value.length == 0 || value[0]==null) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            return;
        }

        this.tail = this.head = new Node<T>(value[0]);
        this.size = 1;
        while(this.size < value.length) {
            tail.setNext(new Node<T>(value[this.size]));
            tail = tail.getNext();
            this.size++;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if(this.head == null)
            this.tail = this.head = newNode;
        else{
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    public void append(T value) {
        Node<T> newNode = new Node<T>(value);
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
            return;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = this.tail.getNext();
        }
        this.size++;
    }

    public int getIndex(T value) {
        if(this.head == null) {
            return -1;
        }
        int index = 0;
        INode<T> temp = this.head;
        while(temp != null) {
            if(temp.getKey().equals(value))
                return index;
            index++;
            temp = temp.getNext();
        }
        return -1;
    }

    public void insert(int atIndex, T value) {
        if(this.head == null && atIndex!=0) {
           throw new CustomLinkedListExceptions(CustomLinkedListExceptions.LinkedListExceptionType.INDEX_OUT_OF_BOUND,
                   "Invalid index for insertion");
        }
        Node<T> newNode = new Node<T>(value);
        if(atIndex == 0) {
            if(this.head == null)
                this.tail = this.head = newNode;
            else {
                newNode.setNext(this.head);
                this.head = newNode;
            }
            this.size++;
            return;
        }
        int count = 0;
        INode<T> temp = this.head;
        while(temp.getNext()!=null && count < atIndex-1) {
            temp = temp.getNext();
            count++;
        }

        if(temp.getNext() != null) {
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            this.size++;
            return;
        }
        else if(temp.getNext() == null && count == atIndex-1) {
            this.tail.setNext(newNode);
            this.tail = this.tail.getNext();
            this.size++;
            return;
        }
        else {
            throw new CustomLinkedListExceptions(CustomLinkedListExceptions.LinkedListExceptionType.INDEX_OUT_OF_BOUND,
                    "Invalid index for insertion");
        }
    }

    public void pop() {
        if(this.head != null) {
            if(this.head == this.tail)
                this.tail = this.head = null;
            else {
                INode<T> temp = this.head;
                this.head = this.head.getNext();
                temp.setNext(null);
            }
            this.size--;
        }
    }

    public void popLast() {
        if(this.head == null)
            return;
        if(this.head.getNext() == null) {
            this.head = this.tail = null;
            this.size--;
            return;
        }

        INode<T> prevTail = this.head;
        while(prevTail.getNext() != this.tail)
            prevTail = prevTail.getNext();
        prevTail.setNext(null);
        this.tail = prevTail;
        this.size--;
    }

    public boolean search(T value) {
        return getIndex(value) != -1;
    }

    public void remove(int atIndex) {
        if(this.head == null) {
            return;
        }
        if(atIndex == 0) {
            if(this.head == this.tail) {
                this.head = this.tail = null;
                this.size--;
                return;
            }
            INode<T> temp = this.head;
            this.head = this.head.getNext();
            temp.setNext(null);
            this.size--;
            return;
        }
        INode<T> temp = this.head;
        INode<T> prevTail = null;
        int count = 0;
        while(temp != null && count < atIndex) {
            prevTail = temp;
            temp = temp.getNext();
            count++;
        }
        if(temp != null) {
            prevTail.setNext(temp.getNext());
            if(temp == this.tail)
                this.tail = prevTail;
            temp.setNext(null);
            this.size--;
            return;
        }
        else {
            throw new CustomLinkedListExceptions(CustomLinkedListExceptions.LinkedListExceptionType.INDEX_OUT_OF_BOUND,
                    "Invalid index for removal");
        }
    }

    private String convToString(INode<T> head) {
        if(head.getNext() == null)
            return head.getKey().toString();
        return head.getKey().toString() + ", " + convToString(head.getNext());
    }

    @Override
    public String toString() {
        if(this.head == null)
            return "";
        return "[" + convToString(this.head) + "]";
    }

    private static <V> INode<V> getMiddleNode(INode<V> head){
        if(head == null)
            return null;
        if(head.getNext() == null)
            return head;
        INode<V> fastNode = head.getNext();
        INode<V> slowNode = head;
        while(fastNode != null && fastNode.getNext() != null) {
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();
        }
        return slowNode;
    }

    public static <V extends Comparable<? super V>> void sort(CustomLinkedList<V> list) {
        CustomLinkedList<V> newList = mergeSort(list.head, list.tail, (a, b) -> a.compareTo(b));
        if(newList != null) {
            list.head = newList.head;
            list.tail = newList.tail;
        }
    }

    public static <V> CustomLinkedList<V> mergeSort(INode<V> head, INode<V> tail, Comparator<? super V> c){
        if(head == null)
            return null;
        if(head.getNext() == null)
            return new CustomLinkedList<V>(head.getKey());
        INode<V> midNode = getMiddleNode(head);
        INode<V> head2 = midNode.getNext();
        midNode.setNext(null);
        CustomLinkedList<V> list1 = mergeSort(head, midNode, c);
        CustomLinkedList<V> list2 = mergeSort(head2, tail, c);
        CustomLinkedList<V> newList = new CustomLinkedList<>();
        INode<V> newHead1 = (list1 != null) ? list1.head : null;
        INode<V> newHead2 = (list2 != null) ? list2.head : null;

        while(newHead1 != null && newHead2 != null) {
            if(c.compare(newHead1.getKey(), newHead2.getKey()) > 0) {
                newList.append(newHead2.getKey());
                newHead2 = newHead2.getNext();
            }
            else {
                newList.append(newHead1.getKey());
                newHead1 = newHead1.getNext();
            }
        }
        while(newHead1 != null) {
            newList.append(newHead1.getKey());
            newHead1 = newHead1.getNext();
        }
        while(newHead2 != null) {
            newList.append(newHead2.getKey());
            newHead2 = newHead2.getNext();
        }
        return newList;
    }

    public static <V> void sort(CustomLinkedList<V> list, Comparator<? super V> c) {
        CustomLinkedList<V> newList = mergeSort(list.head, list.tail, c);
        if(newList != null) {
            list.head = newList.head;
            list.tail = newList.tail;
        }
    }

    protected INode<T> getHead(){
        return this.head;
    }

    protected INode<T> getTail(){
        return this.tail;
    }

    public int size() {
        return this.size;
    }
}