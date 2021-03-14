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
        if(isEmpty())
            throw new CustomLinkedListExceptions(CustomLinkedListExceptions.LinkedListExceptionType.LIST_EMPTY,
                    "Stack Empty");
        return list.getHead().getKey();
    }

    public void pop(){
        list.pop();
    }

    public boolean isEmpty(){
        return list.size()==0;
    }

    public int size(){
        return list.size();
    }
}
