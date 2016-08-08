public class Solution {
	public int strStr(final String haystack, final String needle) {
	    
	    if(needle.isEmpty()) 
	    return -1;
	    if(haystack.isEmpty())
	     return -1;
	    
	    //preprocess
	    int n = haystack.length();
	    int m = needle.length();
	    int[] lps = new int[n+1];
	    
	    lps[0] = 0;
	    
	    int j=0;
	    for(int i = 1; i<n; i++){
	        while(j>0 && haystack.charAt(i)!=haystack.charAt(j)){
	            j = lps[j-1];
	        }
	        
	        if(haystack.charAt(i) == haystack.charAt(j))
	        j++;
	        
	        lps[i] = j;
	        
	    }
	    
	    j=0;
	    
	    for(int i = 0; i < n ; i++){
	        while(j>0&& haystack.charAt(i) != needle.charAt(j)){
	            j=lps[j-1];
	        }
	        
	        if(haystack.charAt(i) == needle.charAt(j))
	            j++;
	       
	       if(j==m){
	           return i+1-j;
	       }
	    }
	    
	    if(j==m){
	        return n-j;
	    }
	    
	    return -1;
	}
}
