
int countKdistinct(String s, int k){

  int res  = 0;
  int n = s.lenth();
  
  
  int cnt = new int[26];
  //consider all the substrins beginning with s[i]
  for(int i = 0; i < n; i++){
    int d = 0;
    Arrays.fill(cnt,0);
    
    //the ending of the substring j 
    //consider the ending of substring[i,j]
    for(int j = i; j < n; j++){
      if(cnt[str.charAt(j)-'a']++ ==0) d++;
      
      if(d == k) res++;
    
    }
  }
  return res;
}
