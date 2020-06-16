package com.sist.ehr.stackqueue;
import java.util.*;

public class PrinterSolution {
	public int solution(int[] priorities, int location) {
        int answer = 1;
        //우선순위 큐를 숫자 높은 순서부터 쓰게 만듬
        PriorityQueue<Integer> priority = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<priorities.length;i++){
            priority.offer(priorities[i]);
        }
        
        System.out.println(priority);   //3,2,2,1

        while(!priority.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == priority.peek()) {  //뽑기만한것 완전히 뺸거는아님
                    if(i == location){
                        return answer;                  //우선 1,  두번째케이스일때는 증가된 answer
                    }
                    priority.poll();                    //우선순위큐에 9빠짐, 9뒤에 1빠짐
                    answer++;                           //2     //3
                }
            }
        }

        return answer;
    }
}
