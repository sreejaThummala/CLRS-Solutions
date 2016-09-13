public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len != s2.length()) return false;
        
        if(s1.equals(s2)) return true;
        char[] count = new char[26];
        for(int i = 0; i < s1.length(); i++)
        {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        
        for(int i = 0; i < 26; i++)
        {
            if(count[i]!=0) return false;
        }
        
        String s11 = "";
        String s12 = "";
        String s21 = "";
        String s22 = "";
        for(int i = 1; i < len ; i++)
        {
            s11 = s1.substring(0,i);
            s12 = s1.substring(i,len);
            s21 = s2.substring(0,i);
            s22 = s2.substring(i,len);
            
            if(isScramble(s11,s21) && isScramble(s12,s22)) return true;
            
            s22 = s2.substring(0, len-i);
            s21 = s2.substring(len-i,len);
            
            if(isScramble(s11,s21) && isScramble(s12,s22)) return true;

            
        }
        
        return false;
    }
}
