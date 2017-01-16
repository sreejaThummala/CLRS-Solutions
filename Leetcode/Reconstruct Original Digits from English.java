public class Solution {
    public String originalDigits(String s) {
       int len = s.length();
       int[] count = new int[10];
        for(int i  = 0; i< len; i++){
            if(s.charAt(i) == 'z') count[0]++;
            if(s.charAt(i) == 'w') count[2]++;
            if(s.charAt(i) == 'x') count[6]++;
            if(s.charAt(i) == 'u') count[4]++;
            if(s.charAt(i) == 'g') count[8]++;
            if(s.charAt(i) == 'f') count[5]++;
            if(s.charAt(i) == 's') count[7]++;
            if(s.charAt(i) == 'h') count[3]++;
            if(s.charAt(i) == 'i') count[9]++;
            if(s.charAt(i) == 'o') count[1]++;
        }
        
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] -= count[6];
        count[9] -= count[8];
        count[9] -= count[5];
        count[1] -= count[0];
        count[1] -= count[4];
        count[1] -= count[2];
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i <= 9; i++){
            if(count[i]>0) for(int j=0; j < count[i]; j++) builder.append(i);
        }
        
        return builder.toString();
        
    }
}
