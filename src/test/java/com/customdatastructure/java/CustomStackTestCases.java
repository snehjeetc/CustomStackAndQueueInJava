package com.customdatastructure.java;


import org.junit.Assert;
import org.junit.Test;

public class CustomStackTestCases {
    @Test
    public void given3Numbers_WhenAddedTheLastShouldBeInTop(){
        CustomStack<Integer> myStack = new CustomStack<Integer>();
        Integer firstNumber = 70;
        Integer secondNumber = 30;
        Integer thirdNumber = 56;
        myStack.push(firstNumber);
        myStack.push(secondNumber);
        myStack.push(thirdNumber);
        Assert.assertEquals(thirdNumber, myStack.peek());
    }
}
