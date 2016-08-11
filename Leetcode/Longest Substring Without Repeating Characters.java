public class Solution {
    public int lengthOfLongestSubstring(String s) {
                int[] count = new int[256];
        
        int maxLength = 1;
        
        if(s.length() == 0) return 0;
        int start = 0;
        int currentLength = 1;
        count[s.charAt(0)]++;
        
        for(int i = 1; i < s.length(); i++)
        {
            if(count[s.charAt(i)] == 0)
            {
                count[s.charAt(i)]++;
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
                continue;
            }
            
            while(start < i)
            {
                if(s.charAt(start) == s.charAt(i))
                {
                    start++;
                    break;
                }
                count[s.charAt(start)]--;
                start++;
            }
            
            currentLength = (i-start+1);
            maxLength = Math.max(currentLength, maxLength);
            
        }
        
        return maxLength;
    }
}
