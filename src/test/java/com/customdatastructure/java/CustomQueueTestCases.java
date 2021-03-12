package com.customdatastructure.java;

import org.junit.Assert;
import org.junit.Test;

public class CustomQueueTestCases {
    @Test
    public void givenNumbers_CreateAQueue_ShouldReturnProperItemAtTheTop(){
        CustomQueue<Integer> myQueue = new CustomQueue<Integer>();
        Integer firstNumber = 70;
        Integer secondNumber = 30;
        Integer thirdNumber = 56;
        myQueue.enqueue(thirdNumber);
        myQueue.enqueue(secondNumber);
        myQueue.enqueue(firstNumber);
        Assert.assertEquals(thirdNumber, myQueue.peek());
    }

    @Test
    public void givenNumbers_CreateAQueue_ShouldRemoveTheFirstElementInTheQueue(){
        CustomQueue<Integer> myQueue = new CustomQueue<Integer>();
        for(int i=1; i<=5; i++)
            myQueue.enqueue(Integer.valueOf(i));
        System.out.println("First Item: " + myQueue.peek());
        myQueue.dequeue();
        Assert.assertEquals(Integer.valueOf(2), myQueue.peek());
    }
}
