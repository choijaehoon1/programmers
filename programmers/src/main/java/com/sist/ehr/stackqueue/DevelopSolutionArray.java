package com.sist.ehr.stackqueue;
import java.util.*;

public class DevelopSolutionArray {
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int[] a = new int[progresses.length];
        for(int i=0; i<progresses.length;i++){
            if((100-progresses[i])%speeds[i] == 0){
                a[i] = (100-progresses[i])/speeds[i];
            } else{
                a[i] = (100-progresses[i])/speeds[i]+1;
            }
            
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int day = a[0];
        int cnt = 1;
        for(int i=1; i<progresses.length;i++){
            System.out.println(a[i]);
            if(a[i]<=day){
                cnt++;
            } else{
                list.add(cnt);
                day = a[i];
                cnt = 1;
            }
        }
        list.add(cnt);
    
        System.out.println(list);
        answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
             answer[i] = list.get(i);
        }
        
        return answer;
    }
}
