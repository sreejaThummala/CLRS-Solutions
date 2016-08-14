public class Solution {
    //pure non - important branches //dfs+pruning
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() >12) return Collections.emptyList();
        
        List<String> result = new ArrayList<>();
        String path = new String();
        helper(s,path,0,result);
        return result;
    }
    
    private void helper(String s, String path , int section, List<String> result){
        if(section == 4) {
            result.add(path);
            return;
        }
        
        for(int i = 0; i < 3;i++){
            if(s.length() -i - 1 < 3-section) continue;  
            if(s.length() - i -1 > (3-section)*3) continue;
            if(i> 0 && s.charAt(0) == '0') break; //cannot be 06 
            if(i==2 && s.substring(0,3).compareTo("255") >0) break; //cannot be greater than 266
            StringBuffer sbPath = new StringBuffer(path);
            sbPath.append(s.substring(0,i+1));
            if(section !=3) sbPath.append(".");
            helper(s.substring(i+1),sbPath.toString(),section+1,result);
        }
        
    }
}
