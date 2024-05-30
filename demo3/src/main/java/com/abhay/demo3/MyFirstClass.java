package com.abhay.demo3;


public class MyFirstClass {
    private final String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello" + myVar;
    }
}
