package com.sist.ehr.hash.complete.search;

public class Carpet {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int row = 0;
        int col = 0;
        int sum = brown + yellow;
        
        for(int i=3; i<sum;i++){        //가운데 빨간색 들어가기 위해서는 가로는 3이상이어야함
            if(sum%i ==0){
                row = sum/i;
                col = sum/row;
                //System.out.println(row+","+col);
                
                int a = row - 2;        //노란색의 가로길이
                int b = col - 2;        //노란색의 세로길이
                if(a*b == yellow && row >= col){
                    answer[0] = row;
                    answer[1] = col;
                }
            }            
        }
        return answer;
    }
}
