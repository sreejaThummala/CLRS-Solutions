public class Solution {
    public String reverseVowels(String s) {
        
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        int start = 0;
        int end = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        
        while(start<end)
        {
            if(!vowels.contains(s.charAt(start)))
            {
                start++;
                continue;
            }
            
            if(!vowels.contains(s.charAt(end)))
            {
                end--;
                continue;
            }
            
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
