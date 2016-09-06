public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        long res = 0;
        boolean neg = false;
        if(str.length()==0) return 0;
        if(str.charAt(0) == '-') neg = true;
        int i = 0;
        if(neg) i++;
        if(str.charAt(0) == '+') i++;

        for(; i < str.length() ; i++)
        {
            if(Character.isDigit(str.charAt(i)))
            res = res*10+(str.charAt(i)-'0');
            if( neg && res*-1 < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(!neg && res > Integer.MAX_VALUE ) return Integer.MAX_VALUE;
            if(!Character.isDigit(str.charAt(i))) break;
        }
        if(neg) res = res*-1;
        return Math.toIntExact(res);
        
    }
}
