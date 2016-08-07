import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int n = in.nextInt();
		    String[] arr = new String[n];
		    for(int i = 0; i < n; i++){
		        arr[i] = in.next();
		    }
		    
		    Arrays.sort(arr);
		    System.out.println(arr[0]+" "+arr[n-1]);
		}
	}
}
