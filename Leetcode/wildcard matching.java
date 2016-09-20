public class Solution {
    public boolean isMatch(String s, String p) {
        
 boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
	    d[0][0] = true;
	    for (int i = 0; i < p.length(); ++i) {
	  	        if (p.charAt(i) == '*') {
	            d[0][i + 1] = d[0][i];
	            for (int j = 0; j < s.length(); ++j) {
	                d[j + 1][i + 1] = d[j][i] || d[j + 1][i] || d[j][i + 1];
	            }
	        } else {
	            for (int j = 0; j < s.length(); ++j) {
	                if (p.charAt(i) == s.charAt(j) || (p.charAt(i) == '?')) {
	                    d[j + 1][i + 1] = d[j][i];
	                }
	            }
	        }
	    }
	    return d[s.length()][p.length()] ;

    }
}
