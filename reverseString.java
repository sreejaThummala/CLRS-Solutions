public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int start = 0;
        int end = s.length()-1;
        while(start<end)
        {
            char sChar = s.charAt(start);
            char eChar = s.charAt(end);
            sb.setCharAt(start,eChar);
            sb.setCharAt(end, sChar);
            start++;
            end--;
        }
        
        return sb.toString();
        
    }
}
