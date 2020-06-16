package com.sist.ehr.stackqueue;

import java.util.*;

public class DevelopSolutionQueue {
	public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int day = 0;
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i] != 0){
                day =  (100-progresses[i])/speeds[i] + 1;
            }else{
                day = (100-progresses[i])/speeds[i];
            }
            q.offer(day);
        }
        int num = 1;
        int standard = q.poll();
        while(!q.isEmpty()){
            day = q.poll();
            if(standard>=day){
                num++;
            }else{
                list.add(num);
                num = 1;
                standard = day;
            }
        }
        list.add(num);
        //System.out.println(list.size());
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
