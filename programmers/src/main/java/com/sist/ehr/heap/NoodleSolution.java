package com.sist.ehr.heap;
import java.util.*;

public class NoodleSolution {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index = 0;
        //우선순위 큐 숫자 높은게 큰거로 만듬(가장 큰 공급량을 stock에 추가하기위해)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int day=0; day < k; day++){     //K일 전까지 비교 오늘은 0일임
            if(index < dates.length && dates[index] == day){    //밀가루 공급받을 수 있는날에는
                priorityQueue.offer(supplies[index]);           //일단 우선순위 큐에 넣는다.
                index++;    //index를 증가시키는데 우에 조건으로 범위 정해줌(date.length-1까지만)
            }
            //밀가루가 부족햊는 시점에 밀가루 공급
            if(stock == 0 ){
                stock += priorityQueue.poll();
                answer++;
            }
            stock--;
        }
        
        return answer;
    }
}
