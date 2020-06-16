package com.sist.ehr.hash;

import java.util.*;
public class RunningSolutionArray {
	public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
//배열을 찍어보려면 for문써야함
//         for(String a:participant){
//             System.out.println(a);
//         }
        
//         for(String a:completion){
//             System.out.println(a);
//         }
        int i=0;
        for(i=0; i<completion.length;i++){
            if(!completion[i].equals(participant[i])){
                return participant[i];
            }
        }
        
        return participant[i];
    }
}
