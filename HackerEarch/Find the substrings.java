/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.util.*;
import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			String s = in.next();
			
			int start = 0;
			int end = 0;
			int res = 0;
			int n = 0;
			int[] cnt = new int[3];
			for(int i = 0; i < s.length(); i++){
				cnt[s.charAt(i)-'a']++;
				if(cnt[s.charAt(i)-'a']==1){
					n++;
					
				}
				if(n<3)	end++;
				if(n==3){
					res += (end - start)*(end-start+1)/2 -1;
					while(start < end){
					   if(--cnt[s.charAt(start)-'a'] ==0) {
					   	n--;
					   	start++;
					   	end++;
					   	break;
					   }
					 start++;
					}
				}
			}
			if(n<3 && start <= end)
			{res += (end-start)*(end-start+1)/2;}
			System.out.println(res);
		}
    }
}
