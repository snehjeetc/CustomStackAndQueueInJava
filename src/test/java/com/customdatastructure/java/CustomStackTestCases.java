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

    @Test
    public void givenStack_popTillEmpty_ShouldReturnTrueIfEmpty(){
        CustomStack<Integer> myStack = new CustomStack<Integer>();
        for(int i=1; i<5; i++)
            myStack.push(Integer.valueOf(i));
        System.out.println("Top: " + myStack.peek());
        while(!myStack.isEmpty())
            myStack.pop();
        Assert.assertTrue(myStack.isEmpty());
    }
}
