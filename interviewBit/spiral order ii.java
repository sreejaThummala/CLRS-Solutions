public class Solution {
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(a==0) return res;
	    
	    int s = a/2+a%2;
	    
	    for(int i = 0; i < a; i++){
	        ArrayList<Integer> row = new ArrayList<Integer>();
	        for(int j =0; j < a; j++){
	            row.add(0);
	        }
	        res.add(row);
	    }
	    int p = 1;
	    for(int i = 0; i < s; i++){
	        for(int j =i; j < a-i; j++){
	            res.get(i).set(j,p);
	            p++;
	        }
	        
	        for(int j = i+1; j < a-i; j++){
	            res.get(j).set(a-i-1,p);
	            p++;
	        }
	        
	        for(int j = a-i-2; j>=i; j--){
	            res.get(a-i-1).set(j,p);
	            p++;
	        }
	        
	        for(int j = a-i-2; j>=i+1; j--){
	            res.get(j).set(i,p);
	            p++;
	        }
	    }
	    
	    return res;
	}
}
