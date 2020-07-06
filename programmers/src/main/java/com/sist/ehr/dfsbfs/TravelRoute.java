package com.sist.ehr.dfsbfs;
import java.util.*;

public class TravelRoute {
	static List<String> list = new ArrayList<String>();
	static String route = "";
	static boolean[] visit;
	
	public static void dfs(String[][] tickets, String end, int cnt) {
		route += end + ",";
		
		if(cnt == tickets.length) {
			list.add(route); 
            return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			String s = tickets[i][0];
            String e = tickets[i][1];
			if(s.equals(end) && !visit[i]) {	//visit[i]가 false일때 조건문 탐
				visit[i] = true;//들렸으면 true로 표시
				dfs(tickets, e, cnt + 1);
				visit[i] = false;//또다른 경로 있나 찾으려고
                route = route.substring(0, route.length()-4);
			}
		}
	}
	
	public static String[] solution(String[][] tickets) {
		for(int i = 0; i < tickets.length; i++) {
			visit = new boolean[tickets.length];
			String start = tickets[i][0];
			String end = tickets[i][1];
			
			if(start.equals("ICN")) {
				route = start + ","; 
                visit[i] = true; 
				dfs(tickets, end, 1);
			}
		}
		
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		for(int i=0; i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		
		return answer;
    }
	
	//ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]]
	public static void main(String[] args) {
		String tickets[][] = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}
							, {"ATL", "ICN"}, {"ATL", "SFO"}}; 
		System.out.println(solution(tickets));
	}
}
