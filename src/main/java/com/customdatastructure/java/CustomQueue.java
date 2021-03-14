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
        return list.getHead().getKey();
    }

    public void dequeue() {
        list.pop();
    }

    public boolean isEmpty(){
        return list.size()==0;
    }

    public int size(){
        return list.size();
    }
}
