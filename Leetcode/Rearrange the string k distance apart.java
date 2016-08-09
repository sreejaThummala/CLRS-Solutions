public class Solution{
  public String rearrangeString(String str, int k){
    if(k == 0) return str;
    int len = str.length();
    
    StringBuffer res;
    res.setLength(len);
    
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
      
    }
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
