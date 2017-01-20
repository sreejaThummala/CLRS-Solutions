package com.google.challenges; 

public class Answer {   
 public static int answer(int start, int length) {
      int step = length;
      int res = xor(start,start+length-1);
      start += length;
      length--;
      while(length > 0){
          res ^= xor(start,start+length-1);
          start += step;
          length--;
      }
      return res;

    } 
    
    private static int xor(int n){
       switch(n%4){
         case 0: return n;
         case 1: return 1;
         case 2: return n+1;
        default: return 0;
}
}
private static int xor(int a, int b){
	return xor(a-1)^xor(b);
}
}
