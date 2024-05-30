package com.abhay.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;


    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellStory() {
        return "The bean i sSaying" + myFirstClass.sayHello();
    }
}
