public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int x) {
        int total_ones = 0;
        while (x != 0) {
             x = x & (x-1);
    total_ones++;
  }
  return total_ones;
    }
