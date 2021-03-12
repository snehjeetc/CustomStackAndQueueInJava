package com.customdatastructure.java;

@SuppressWarnings("unchecked")
public class CustomStack<T> {
    private CustomLinkedList<T> list;
    public CustomStack(){
        list = new CustomLinkedList<T>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T peek(){
        return list.getHead().getValue();
    }

}
