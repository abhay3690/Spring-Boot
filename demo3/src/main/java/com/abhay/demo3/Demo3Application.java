package com.abhay.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Demo3Application.class, args);

        MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellStory());

//		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
//		System.out.println(myFirstClass.sayHello());
    }
////	@Bean
//	public MyFirstClass myFirstClass(){
//		return new MyFirstClass();
//	}

}

