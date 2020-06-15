package com.sist.ehr.stackqueue;

public class TopSolutionArray {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i=heights.length-1; i>0;i--){
            for(int j=0; j<i;j++){
                if(heights[i] < heights[j]){
                    answer[i]=j+1;
                }
            }
        }
        return answer;
    }
}
