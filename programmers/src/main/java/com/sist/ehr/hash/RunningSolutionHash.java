package com.sist.ehr.hash;

import java.util.*;
public class RunningSolutionHash {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String p:participant){
            map.put(p,map.getOrDefault(p,0) +1); //값이있으면 그 value값, 없으면 0 
        }
        //System.out.println(map);//{ana=1, mislav=2, stanko=1}
        
        for(String c:completion){
            map.put(c,map.get(c)-1);
        }
        //System.out.println(map);//{ana=0, mislav=1, stanko=0}
        
        for(String key:map.keySet()){   //keySet()은 키의 값들을 다 가져온 것
            if(map.get(key) != 0){
                answer = key;
            }
        }
        
        return answer;
    }
}
