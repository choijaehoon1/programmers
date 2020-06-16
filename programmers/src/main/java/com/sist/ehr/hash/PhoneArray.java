package com.sist.ehr.hash;

public class PhoneArray {
	public boolean solution(String[] phone_book) {
        
        for(int i=0; i<phone_book.length;i++){
            for(int j=i+1;j<phone_book.length;j++){
                if(phone_book[j].startsWith(phone_book[i]) ||
                  phone_book[i].startsWith(phone_book[j])){
                    return false;
                }
            }
        }
        return true;
    }
}
