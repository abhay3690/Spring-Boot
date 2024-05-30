package com.work.hotl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
		System.out.println("HEllo world");
		int arr1[]={5,7,5,4,12};
		int sum = getSum(arr1);
		System.out.println("Sum = " +sum);
	}
	public static int getSum(int arr[]){
		int s =0;
		for (int i = 0; i<arr.length;i++){
			s+=arr[i];
		}
		s = s+65;
		return s;
	}

}
