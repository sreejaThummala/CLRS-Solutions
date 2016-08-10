/**
Assume you have an array of length n initialized all 0s and are given k update operations.
Each operation is representated as triplet [startIdx, endIdx, inc] which increments
each element of subarry of [startIdx, endIdx] with ic;
Return the modified arary after all the k operations were execute
**/
public class Solution{
  public int[] getModifiedArray(int len ,int[][] updates){
    int[] res = new int[len];
    for(int[] update: updates){
      res[update[0]] += update[2];
      if(update[1]+1 < len) res[updates[1]+1] = -updates[2];
    }
    
    int value = 0;
    for(int i = 0; i < len; i++){
      value += res[i];
      res[i] = value;
    }
    
    return res;
  }
}
