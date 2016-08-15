/**
You are playing the following flip game with your friend. Given a string that contaisn only these two characters: + and -, you and your friend take
turns to flip two consecutive ++ and --. The game ends when a person can no longer make a move and therfore the other person will be winner
**/
public boolean canWin(String s){
  if(s==null||s.length()==0){
    return false;
  }
  
  return helper(s.toCharArray());

}

public boolean helper(char[] arr){
  for(int i = 0; i < arr.length-1; i++){
    if(arr[i] == '+' && arr[i+1] == '+'){
      ar[i] = '-';
      arr[i+1] == '-';
      
      if(!helper(arr)) return true; //other player cannot win then true
      
      arr[i] = '+';
      arr[i+1] = '+';
      
    }
  }
  return false; 
}
