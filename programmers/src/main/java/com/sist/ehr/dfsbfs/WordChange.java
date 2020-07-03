package com.sist.ehr.dfsbfs;
import java.util.*;

public class WordChange {
	static class Node{
		private String word;
		private int count;
		
		public Node(String word, int count){
			this.word = word;
			this.count = count;
		}
		
		public String getWord() {
			return this.word;
		} 
		
		public int getCount() {
			return this.count;
		}
		
	}
	
	public static int solution(String begin, String target, String[] words) {
		boolean flag = false;
		
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(target)) {
				flag = true;
				break;
			}
		}
		if(!flag) return 0;		//즉 flag가 false일때 임 -> 원하는 값이 words배열에 없을때 
		
		
		return bfs(begin, target, words);
	}
		
	
	public static int bfs(String begin, String target, String[] words) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(begin,0));			//처음에는 hit 추가
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();		//hit빼서 BFS시작				//hot으로 bfs시작...
			
			if(curNode.getWord() == target) {	//target과 같으면 그때의 count값 반환
				return curNode.getCount();
			}

			for(int i=0; i<words.length;i++) {
				if(!compare(curNode.getWord(),words[i])) continue;
				q.offer(new Node(words[i],curNode.getCount()+1));//hot들어감
			}
		}
		
		return 0;
	}
	
	
	public static boolean compare(String cur, String n) {
		int cnt = 0;
		
		for(int i=0; i< n.length();i++) {
			if(cur.charAt(i) != n.charAt(i)) {
				cnt++;
			}
		}
		if(cnt == 1) {
			return true;		//단어가 하나만 다른경우임, 큐에 더함 
		} else {
			return false;		//continue문 타게되서 offer안하고 빠져나감(continue는 케이스제외느낌)  즉  !fasle == true되서 조건걸림
		}
		
	}
	
	
    public static void main(String[] args) {
    	String begin = "hit";
    	String target = "cog";
    	
		String words[] = {"hot", "dot", "dog", "lot", "log", "cog"}; 
		
		System.out.println(solution(begin,target,words));
	}
	 
}

