package com.sist.ehr.sort;

import java.util.*;
public class MaxSolution {
	public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
             nums[i]= String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums,new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){     //간단한 케이스
                    return o2.compareTo(o1);        //desc
                }
                
                String sum = o1 + o2;               //330       이런식으로 비교 
                String rsum = o2 + o1;              //303
                
                return rsum.compareTo(sum);         //desc
            }
        });
        
        if(nums[0].equals("0")){         //nums는 현재 desc인데 맨앞이 0이라는 것은 0000000인것임
            return "0";                  //[0000]은 그냥 0으로 리턴한다
        }
        
        StringBuilder sb = new StringBuilder();     //StringBuilder가 append()씀(속도빠름)
        for(int i=0; i< nums.length;i++){
            sb.append(nums[i]);
        }
        answer = sb.toString();                     //StringBuilder는 toString()해야 String임
        
        return answer;
    }
}
