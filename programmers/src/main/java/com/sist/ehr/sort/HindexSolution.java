package com.sist.ehr.sort;

import java.util.Arrays;

public class HindexSolution {
	public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h=0;
        int k=0;
        for(int i=0; i<citations.length;i++){
            h = citations[i];               //0 //1 //3 //5 //6     //인용횟수
            k = citations.length - i;       //5 //4 //3 //2 //1     //인용논문의 수
            //끝까지 해볼필요없음 -> 가면갈수록 인용논문의 수는 줄어드므로(최소 1편임)
            if(h>=k){
                answer = k;
                break;
            }   
        }
        return answer;
    }
}
