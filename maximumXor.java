import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int xorMax = Integer.MIN_VALUE;
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int R = in.nextInt();
        
        for(int i = L ; i <= R; i++){
            for(int j = i+1; j <=R; j++){
                int xor = i^j;
                if(xor > xorMax){
                    xorMax = xor;
                }
            }
        }
        
        System.out.println(xorMax);
    }
}
