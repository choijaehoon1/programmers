package com.sist.ehr.stackqueue;

import java.util.*;
public class TruckSolution {
	class Truck{
        int weight;
        int entry;
        
        Truck(int weight, int entry){
            this.weight = weight;
            this.entry = entry;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<Truck>();  
        Queue<Truck> bridge = new LinkedList<Truck>();
        
        for(int i=0; i<truck_weights.length;i++){
            waiting.offer(new Truck(truck_weights[i],0));   		//offer -> add와 같다
        }
        
        int time = 0;
        int totalWeight = 0;

        while(!waiting.isEmpty() || !bridge.isEmpty()){     
            time++;    //시간은 계속 1초씩 증가
            if(!bridge.isEmpty()){
                Truck t = bridge.peek();                        	//peek()은 꺼내기(지우지는않음)
                if(time - t.entry >= bridge_length){
                    totalWeight -= t.weight;
                    bridge.poll();
                }
            }
            
            if(!waiting.isEmpty()){
                if(totalWeight + waiting.peek().weight <= weight){	//peek()은 꺼내기(지우지는않음)
                    Truck t = waiting.poll();                     	//poll()은 꺼내는것
                    totalWeight += t.weight;	
                    bridge.offer(new Truck(t.weight,time));      	//offer()가 add
                                                                  	//시간으로 entry줘서 생성
                }
            }
        }
        
        return time;
    }
	
}
