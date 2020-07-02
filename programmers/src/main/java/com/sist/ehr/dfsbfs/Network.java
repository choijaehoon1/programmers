package com.sist.ehr.dfsbfs;

public class Network {
	public static void main(String[] args) {
        int[] n = {3, 3};
        int[][][] computers = {
                {
                    {1,1,0}, 
                    {1,1,0}, 
                    {0,0,1}
                },
                {
                    {1,1,0}, 
                    {1,1,1}, 
                    {0,1,1}
                }
        };
        for(int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], computers[i]));
        }
    }
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[computers.length];
		
		for(int i=0; i<computers.length;i++) {
			visited[i] = false;
		}
		
		for(int i=0; i<computers.length;i++) {
			if(visited[i] == false) {
				answer++;
				dfs(i,visited,computers);
			}
		}
		
		return answer;
		
	}
	
	public static void dfs(int node, boolean[] visited, int[][] computers) {
		visited[node] = true; 				//방문했으면 ture로 변경
		for(int i=0; i<computers.length;i++) {
			if(visited[i] == false && computers[node][i] == 1){	//아직방문안한 노드이고 에노드랑 연결되면
				dfs(i,visited,computers);						//그 노드가지고 DFS수행
			}
		}
	}
	
}
