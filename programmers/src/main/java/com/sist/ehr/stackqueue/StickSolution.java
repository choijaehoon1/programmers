package com.sist.ehr.stackqueue;

import java.util.*;

public class StickSolution {
	public int solution(String arrangement) {
        int answer = 0;
        arrangement = arrangement.replace("()","0");     //레이저뽑아내기위해 0으로 바꿈
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<arrangement.length();i++){
            char ch = arrangement.charAt(i);
            //System.out.println(ch);
            if(ch == '('){
                stack.push(ch);     //stack에 '('를 계속쌓음
            } else if(ch == ')'){
                answer += 1;        //')'만나면 개수는 하나 증가
                stack.pop();        //But 마지막 '('삭제해서 짝맞춰줌
            } else if(ch == '0'){
                answer += stack.size();     //레이저만나서 stack에 쌓여있는만큼 더함
            }
            
        }
        
        
        return answer;
    }
}
