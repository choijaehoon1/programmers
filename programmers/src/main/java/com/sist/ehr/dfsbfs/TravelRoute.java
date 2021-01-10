//여행경로
import java.util.*;
class Solution {
    ArrayList<String> list = new ArrayList<>();
    
    public void dfs(String[][] tickets, String route, String t ,int cnt ,int[] visit){
        t += route + ',';
        if ( cnt == tickets.length){
            list.add(t);
        }
        else{
            for(int i=0;i<tickets.length;i++){
                if(route.equals(tickets[i][0]) && visit[i] == 0){
                    visit[i] = 1;
                    dfs(tickets,tickets[i][1],t,cnt+1,visit);
                    visit[i] = 0;
                }
            }
        }
        
    }
    
    public String[] solution(String[][] tickets) {
        int[] visit = new int[tickets.length];
        dfs(tickets,"ICN","",0,visit);
        Collections.sort(list);
        // System.out.println(list.toString());
        String[] answer = list.get(0).split(",");
            
        return answer;
    }
}
