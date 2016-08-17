
public static ArrayList<String> combParenthesis(int pairs) {
    ArrayList<String> res = new ArrayList<String>();
    _combParanthesis(0,0,"",pairs,res);
    return res;
}

private static void _combParanthesis(int left, int right, String cur,int pairs, ArrayList<String> res){
    if(right>left){
        return;
    }
    
    if(right>pairs || left >pairs){
        return;
    }
    
    if(right==left && right == pairs){
        res.add(cur);
        return;
    }
    
    _combParanthesis(left+1,right,cur+"(",pairs,res);
    _combParanthesis(left,right+1, cur+")",pairs,res);
}
