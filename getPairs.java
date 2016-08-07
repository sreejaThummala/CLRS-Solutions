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
		    int n  = in.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i<n; i++){
		        arr[i] = in.nextInt();
		    }
		    
		    int[] pairs = getPairs(arr,n);
		    
		    if(pairs == null){
		        System.out.println("no pairs");
		    }else{
		        System.out.println(pairs[0]+" "+pairs[1]+" "+pairs[2]+" "+pairs[3]);
		    }
		}
	}
	
	
	private static int[] getPairs(int[] arr, int n){
	    
	    Map<Integer, Integer> reverseIdx = new HashMap<Integer,Integer>();
	    for(int i = 0; i < n ; i++){
	        reverseIdx.put(arr[i],i);
	    }
	    Arrays.sort(arr);
	    
	    Map<Integer, Pair> pairMap = new HashMap<Integer, Pair>();
	    
	    int[] pairs = null;
	    for(int i = 0; i<n; i++){
	        for(int j = i+1; j < n; j++){
	            int sum = arr[i]+arr[j];
	            if(pairMap.containsKey(sum)){
	                pairs = new int[4];
	                Pair pair = pairMap.get(sum);
	                pairs[0] = pair.first;
	                pairs[1] = pair.second;
	                
	                pairs[2] = Math.min(reverseIdx.get(arr[i]),reverseIdx.get(arr[j]));
	                pairs[3] = Math.max(reverseIdx.get(arr[i]),reverseIdx.get(arr[j]));
	                return pairs;
	            }
	            
	            Pair pair = new Pair();
	            pair.first = Math.min(reverseIdx.get(arr[i]),reverseIdx.get(arr[j]));
	            pair.second =  Math.max(reverseIdx.get(arr[i]),reverseIdx.get(arr[j]));
	            pairMap.put(sum, pair);
	        }
	    }
	    
	    return pairs;
	}
	
	
}

class Pair{
    int first;
    int second;
}
