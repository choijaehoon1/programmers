package com.sist.ehr.recursion;

import java.util.Scanner;

public class Star {

	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		arr = new char[N][N];
		star(0,0,N,false);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	
	public static void star(int x, int y, int N, boolean blank) {
		//공백일 경우 arr[1][1], arr[1][4]...
		if(blank) {
			for(int i=x; i<x+N; i++) {
				for(int j=y; j<y+N; j++) {		//초기 x=0,y=0,N=3     그다음 x=0,y=3,N=3
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		//더이상 쪼갤 수 없는 블럭일 때
		if(N==1) {
			arr[x][y] ='*';
			return;
		}
		
		/*
		   N=27 일 경우 한 블록의 사이즈는 9이고, 
		   N=9 일 경우 한 블록의 사이즈는 3이듯
		   해당 블록의 한 칸을 담을 변수를 의미 size
        
		   count는 별 출력 누적을 의미
		 */
		int size = N/3;
		int count = 0;
		
		for(int i=x; i<x+N; i+=size) {
			for(int j=y; j<y+N; j+=size) {
				count++;
				if(count ==5) {
					star(i,j,size,true);
				} else {
					star(i,j,size,false);
				}
				
			}
		}
		
		
	}
}
