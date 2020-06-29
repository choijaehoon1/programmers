package com.sist.ehr.recursion;

import java.util.Scanner;

public class Fibonacci {
//	f(0) = 0
//	f(1) = 1
//	f(2) = f(1) + f(0) =1
//	f(3) = f(2) + f(1) = 2*f(1) + f(0) = 2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int result = fibonacci(n);
		System.out.println(result);
	}

	
	public static int fibonacci(int n) {
		if(n<=1) {
			return n;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
