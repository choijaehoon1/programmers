package com.sist.ehr.sort;

import java.util.Arrays;

public class Ksolution {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        //2차원 배열은 아래와 같이 되어있는것임
        //253
        //441
        //173
        //copyOfRange함수는 시작인덱스 포함, 끝인덱스 포함 X -> 따라서 마지막인자는 -1 불필요
        for(int i=0; i<commands.length;i++){
            int[] tmp = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            //tmp에는 원배열에서 잘라낸 값들이 들어가있음
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}
