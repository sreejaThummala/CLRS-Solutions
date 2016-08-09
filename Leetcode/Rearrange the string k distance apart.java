public class Solution{
  public String rearrangeString(String str, int k){
    if(k == 0) return str;
    int len = str.length();
    
    ArrayList<Character> res = new ArrayList<Character>();
    
    int[] freq = new int[26];
    
    for(int i = 0; i < len ; i++){
      freq[str.charAt(i)-'a']++;
    }
    
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    
    for(int i = 0; i < 26; i++){
      pq.offer(new Pair((char)i+'a' , freq[i]);
    }
    
    while(!pq.isEmpty()){
      Set<Pair> cache = new HashSet<Pair>();
      int c = Math.min(k, len);
      for(int i = 0; i <c; i++){
        if(pq.isEmpty()) return "";
        Pair tmp = pq.poll();
        res.add(tmp.e);
        if(tmp.f>1){
          cache.add(new Pair(tmp.f-1,tmp.e);
        }
        len--;
      }
      for(Pair p: cache) pq.offer(p);
    }
    
    String ans = "";
    for(int i = 0; i < res.size(); i++){
      ans += res.get(i);
    }
    return ans;
  }
}

class Pair implements Comparator<Pair>{
  
  int f;
  char e;
  public Pair(int f, char e){
    this.f = f;
    this.e = e;
  }
  
  @Override
  public int compareTo(Pair p1, Pair p2){
    return p2.f - p1.f;
  }
  
  @Override
  public boolean equals(Pair p){
    
    return (p != null) &&( this.f == p.f && this.e == p.e) ;
  }
}
