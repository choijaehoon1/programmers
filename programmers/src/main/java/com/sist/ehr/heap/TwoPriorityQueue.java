package com.sist.ehr.heap;
import java.util.*;
public class TwoPriorityQueue {
	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rpriorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length;i++){
            String[] oper = operations[i].split(" ");
            if(oper[0].equals("I")){
                priorityQueue.offer(Integer.parseInt(oper[1]));
                rpriorityQueue.offer(Integer.parseInt(oper[1]));
            }
            if(oper[0].equals("D")){
                if(!priorityQueue.isEmpty()){
                    if(oper[1].equals("1")){
                        int max = rpriorityQueue.poll();    //뽑는순간 최대우선순위큐에서는 사라짐
                        priorityQueue.remove(max);          //최소 우선순위큐에서도 삭제시켜줘야함
                    } else if(oper[1].equals("-1")){
                        int min = priorityQueue.poll();     //뽑는순간 최소우선순위큐에서는 사라짐
                        rpriorityQueue.remove(min);         //최대 우선순위큐에서도 삭제시켜줘야함
                    }
                }
            }
            //System.out.println(priorityQueue);
        }
        
        // System.out.println(rpriorityQueue);
        if(!priorityQueue.isEmpty()){
         answer[0] = rpriorityQueue.poll();
         answer[1] = priorityQueue.poll();
        }
        return answer;
    }
}
