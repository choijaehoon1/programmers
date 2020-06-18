package com.sist.ehr.heap;
import java.util.*;

public class hotterSolution {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length;i++){
            priorityQueue.offer(scoville[i]);
        }
        System.out.println(priorityQueue);      //1,2,3,9,10,12
        int cnt = 0;
        while(priorityQueue.peek() < K){
            if(priorityQueue.size() == 1){      //queue의 사이즈가 1이면 제일앞의 값이 K 보다 작은것
                return -1;                      //즉 K이상 만들 수 없으니 -1 
            }
            
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            
            int result = a + b *2;
            priorityQueue.offer(result);        //우선순위 큐이므로 숫자가 낮은게 앞으로 감
            answer++;
        }
        
        return answer;
    }
}
