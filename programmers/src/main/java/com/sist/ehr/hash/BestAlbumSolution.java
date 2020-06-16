package com.sist.ehr.hash;
import java.util.*;

class Song implements Comparable<Song>{
    private int idx;
    private int plays;
    
    public Song(){}
    
    public Song(int idx, int plays){
        this.idx = idx;
        this.plays = plays;
    }
    
    public int getIdx(){
        return this.idx;
    }
    
    public void setIdx(int idx){
        this.idx = idx;
    }
    
    public int compareTo(Song o){
        if(this.plays == o.plays){      //재생수 같을때
            if(this.idx > o.idx){       //고유번호 낮은게 큰거임
                return 1;
            } else{
                return -1;
            }
        } else if(this.plays < o.plays){ //재생수 많은 것이 큰것
            return 1;
        } else{
            return -1;
        }    
    }
    
    
}
public class BestAlbumSolution {
	public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String,Integer> rankMap = new HashMap<String, Integer>();
        for(int i=0; i<genres.length;i++){          //장르별로 재생수 합 구하기
            rankMap.put(genres[i],rankMap.getOrDefault(genres[i],0) +plays[i]);
        }
        System.out.println(rankMap);
        
        //재생수 높은 것 뽑기위한 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(Integer value:rankMap.values()){
            pq.add(value);
        }
        System.out.println(pq);
        
        //hashMap.get(키)를 이용하기 위해 현재 hashMap 앞 뒤 바꿈
        HashMap<Integer,String> rHashMap = new HashMap<Integer, String>();
        for(String key:rankMap.keySet()){
            rHashMap.put(rankMap.get(key),key);
        }
        System.out.println(rHashMap);
        
        int pqSize = pq.size();
        String[] rankArr = new String[pqSize];//가장높은 장르부터 배열로만듬
        for(int i=0; i < pqSize;i++){
            rankArr[i] = rHashMap.get(pq.poll());
            System.out.println(rankArr[i]);//pop, classic
        }
        
        Map<String,PriorityQueue<Song>> songsRank = new HashMap<String, PriorityQueue<Song>>();
        for(int i=0; i<plays.length;i++){
            if(songsRank.containsKey(genres[i])){//장르로 구분(장르있을시 비교해서 우선순위대로 넣음)
                songsRank.get(genres[i]).add(new Song(i,plays[i]));
            } else{ //장르 없을시 일단 put하고  map에 추가
                songsRank.put(genres[i],new PriorityQueue<Song>());//PriorityQueue<>()도 가능
                songsRank.get(genres[i]).add(new Song(i,plays[i])); //i가 즉 idx값임(고유번호)
            }
        }
        System.out.println(songsRank);//우선순위순으로 pop 2개, classic 3개 들어있음
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i< rankArr.length;i++){    //장르별로 1위와 2위를 뽑기 위한것
            list.add(songsRank.get(rankArr[i]).poll().getIdx());
            
            if(songsRank.get(rankArr[i]).peek() != null){
                list.add(songsRank.get(rankArr[i]).poll().getIdx());
            }
            //장르의 값이 하나뿐일때는 if문 안걸려서 하나만 들어가게 됨
        }
        System.out.println(list);//4,1,3,0
        
        answer = new int[list.size()];
        for(int i=0; i< list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
