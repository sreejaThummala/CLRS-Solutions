public class Solution {
    public String largestNumber(int[] num) {
        int length = num.length;
        if(length == 0)
        return "";
        if(length==1)
        return ""+num[0];
        
        for(int i=1;i<length;i++){
            int temp = num[i];
            int j;
            for(j=i-1;j>=0&&((temp+""+num[j]).compareTo(num[j]+""+temp)>0);j--){
                num[j+1] = num[j];
            }
            num[j+1] = temp;
        }
        
        String str = "";
        for(int i=0;i<length;i++){
            str = str+""+num[i];
            
        }
        
        int s = 0;
        for(;s<length-1&&num[s]==0;s++);
        
        return str.substring(s);
    }
}
