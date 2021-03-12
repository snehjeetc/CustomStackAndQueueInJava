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
}
