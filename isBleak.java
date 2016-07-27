import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static boolean isBleak(int n){
        for(int i = 1; i <= n ; i++){
            if(Integer.bitCount(i)+i == n)
                return false;
            
        }
        return true;
    }
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while(t>0)
	    {
	        t--;
	        int n = in.nextInt();
	        System.out.println(isBleak(n)?1:0);
	    }
	}
}
