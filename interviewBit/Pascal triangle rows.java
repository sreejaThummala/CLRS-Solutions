public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> res  = new ArrayList<ArrayList<Integer>>();
	    if(a==0) return res;
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        res.add(firstRow);
	    for(int i =1; i <a; i++){
	        ArrayList<Integer> row = new ArrayList<Integer>();
	        row.add(1);
	        for(int j  = 1; j <i; j++){
	           row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
	        }
	        row.add(1);
	        res.add(row);
	    }
	    
	    return res;
	}
}
