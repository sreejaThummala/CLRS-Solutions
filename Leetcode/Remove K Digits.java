public class Solution {
    public String removeKdigits(String num, int k) {
        
        int n = num.length();
        Stack <Character> s = new Stack<>();
        
        for(int i = 0; i < n; i++)
        {
            while(!s.isEmpty() && num.charAt(i) < s.peek() && k> 0 )
            {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));

        }
        
        
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
        {
            sb.append(s.pop());
        }
        
        String res = sb.reverse().toString();
        res = res.substring(0,Math.min(n-k,res.length()));
        
        int i = 0;
        for(; i < res.length() && (res.charAt(i) == '0'); i++);
        res = res.substring(i);
        if(res.equals("")) res = "0";
        return res;
        
    }
}
