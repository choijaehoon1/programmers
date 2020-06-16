package com.sist.ehr.hash;
import java.util.*;

public class PhoneHash {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String,String> map = new LinkedHashMap<String,String>();//map은 순서가없는데 LinkedHashMap은 순서있음
        
        for(String phone:phone_book){
            map.put(phone,"prefix");
        }
        System.out.println(map);
        
        for(String phone:phone_book){                //phone을 하나씩꺼낸다
            for(int i=0; i<phone.length();i++){      //phone의 한자리씩꺼냄
                if(map.containsKey(phone.substring(0,i))) return false;//지정한키가 있는지 여부확인
            }
        }
        
        return answer;
    }
}
