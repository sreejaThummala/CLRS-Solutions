
import java.util.*;
import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			String[] arr = new String[n];
			for(int i = 0; i < n ;i++){
				arr[i] = in.next();
			}
			
			System.out.println(isSymmetric(arr));
		}
		
		return;
    }
    
    private static String isSymmetric(String[] arr){
    	int n = arr.length;
    	for(int i = 0; i < n; i++){
    		if(!arr[i].equals(new StringBuilder(arr[i]).reverse().toString())){
    			return "NO";
    		}
    	}
    	
    	for(int i = 0; i < n/2; i++){
    		for(int j = 0; j < n; j++){
    			if(arr[i].charAt(j) != arr[n-i-1].charAt(j)){
    				return "NO";
    			}
    		}
    		
    	}
    	
    	return "YES";
    }
}
