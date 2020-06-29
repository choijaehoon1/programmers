package com.sist.ehr.hash.complete.search;

public class Exam {
	public int[] solution(int[] answers) {      
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int aa = 0;
        int bb = 0;
        int cc = 0;
        for(int i=0;i<answers.length;i++){
            if(answers[i] == a[i%5]){
                aa++;
            }
            if(answers[i] == b[i%8]){
                bb++;
            }
            if(answers[i] == c[i%10]){
                cc++;
            }
        }
        System.out.println(aa +""+ bb +""+cc);
        
        if(aa==bb && bb==cc ){
            int[] answer = {1,2,3};
            return answer;
        }
        
        if(aa==bb && aa>cc){
            int[] answer = {1,2};
            return answer;
        }
        if(bb==cc && bb>aa){
            int[] answer = {2,3};
            return answer;
        }
        if(aa==cc && aa>bb){
            int[] answer = {1,3};
            return answer;
        }
       
        if(aa>bb && aa>cc){
            int[] answer = {1};
            return answer;
        } 
        if(bb>aa && bb>cc ){
            int[] answer = {2};
            return answer;
        }
        else{
            int[] answer = {3};
            return answer;
        }
    }
}
