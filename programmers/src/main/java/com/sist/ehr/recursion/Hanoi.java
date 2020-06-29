package com.sist.ehr.recursion;

import java.util.Scanner;

public class Hanoi {
//	1. hanoi(3 1 2 3) 시작 
//
//	2. hanoi(2 1 3 2)
//
//	3. hanoi(1 1 2 3) 호출 시 매개 변수에 (1, 1, 2, 3)
//	따라서 1 3 찍힘 return
//
//	다시 2번으로 옴(2 1 3 2)
//	1 2 찍힘
//	4. hanoi(1 3 1 2) 호출 
//	3 2 찍히고 리턴
//	다시 1번으로 옴 (3 1 2 3)
//	sb.append로 1 3 찍힘
//
//	5. hanoi(2 2 1 3) 호출
//	여기서 다시 esle문 처음부터 걸리게 됨
//	6. hanoi(1 2 3 1) 호출
//	2 1 찍히고 리턴
//	5번으로 돌아감 (2 2 1 3)
//	2 3 찍힘
//	7. hanoi(1 1 2 3) 호출
//	1 3 찍히고 리턴

	static int n,cnt=0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		hanoi(n,1,2,3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void hanoi(int n,int from,int by,int to) {
		cnt++;
		if(n==1) { // 원판이 1개일 때
			sb.append(from+" "+to+"\n");
			return;
		}else { // 원판이 1개가 아닐 때
			hanoi(n-1,from,to,by); // n-1을 한 후, 1->3->2로 원판을 전달
			sb.append(from+" "+to+"\n");
			hanoi(n-1,by,from,to); // n-1을 한 후, 2->1->3으로 원판을 전달
		}
	}

}
