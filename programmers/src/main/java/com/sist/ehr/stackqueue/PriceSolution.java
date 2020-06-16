package com.sist.ehr.stackqueue;

public class PriceSolution {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length;i++){
            int cnt = 0;    //여기서 초기화 시켜야함(시간비교위해)
            for(int j=i+1;j<prices.length;j++){
                cnt++;
                if(prices[i]>prices[j]){    //예외는 앞의 숫자가 더 클때
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
