package com.sist.ehr.hash;
import java.util.*;

public class SpySolution {
	public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i=0; i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0) +1);
        }
        System.out.println(map); //{eyewear=1, headgear=2}
        
        for(String key:map.keySet()){
            answer *= map.get(key) +1;
        }
        answer += -1;
        
        return answer;
    }
}
