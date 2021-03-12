package com.customdatastructure.java;

@SuppressWarnings("unchecked")
public class CustomQueue<T> {
    private CustomLinkedList<T> list;
    public CustomQueue(){
        list = new CustomLinkedList<T>();
    }

    public void enqueue(T item){
        list.append(item);
    }

    public T peek(){
        return list.getHead().getValue();
    }

}
