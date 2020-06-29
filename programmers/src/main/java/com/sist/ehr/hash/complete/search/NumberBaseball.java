package com.sist.ehr.hash.complete.search;
import java.util.*;
public class NumberBaseball {
	public int solution(int[][] baseball) {
        Stack<String> stack = new Stack<String>();
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                for(int k=1; k<10;k++){
                    if(i!=j && j!=k && i!=k){
                        stack.add(String.valueOf(i*100 + j*10 + k));    //될 수 있는 숫자 다 넣음
                    }
                }
            }
        }   
        Stack<String> answer = new Stack<String>();
        while(!stack.empty()){
            String num = stack.pop();
            boolean flag = false;
            
            for(int i=0; i<baseball.length;i++){
                int strike = strike(num,String.valueOf(baseball[i][0]));
                int ball = ball(num,String.valueOf(baseball[i][0])) - strike;   //볼은 볼 - 스트라이크해야 됨
                if(strike != baseball[i][1] || ball !=baseball[i][2]){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                answer.add(num);
            }
        }
        return answer.size();
    }
    
    public static int strike(String num,String target){
            int cnt = 0;
            for(int i=0; i<target.length();i++){
                if(num.charAt(i) == target.charAt(i)){
                    cnt++;
                }
            }
            return cnt;
    }
        
    public static int ball(String num, String target){
        int cnt = 0;
        for(int i=0; i<target.length();i++){
            if(num.contains(String.valueOf(target.charAt(i)))){
                cnt++;
            }
        }
        return cnt;
    }
}
