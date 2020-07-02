package com.sist.ehr.dfsbfs;

public class TargetNumber {
	static int answer = 0;
	
    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int node){
        if(node == numbers.length){
            int sum = 0;
            
            for(int i=0; i<numbers.length;i++){
                sum += numbers[i];
            }
            if(sum == target){
                answer++;
            }
        } else{
            numbers[node] *= 1;			  	//+연산은 왼쪽노드방문		값에 *1을 하면 그대로 유지됨	+연산은 +, -연산은 -	
            dfs(numbers, target, node+1);
            
            numbers[node] *= -1;			//-연산은 오른쪽노드방문	값에 *-1을 하면 부호가 바뀌게 됨 
            dfs(numbers, target, node+1);
        }
        
        
    }
    public static void main(String[] args) {
		int n[] = {1,1,1,1,1}; 
		int target = 3;
		
		System.out.println(solution(n,target));
	}

}
