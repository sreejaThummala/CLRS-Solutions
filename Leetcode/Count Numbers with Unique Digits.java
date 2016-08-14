public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
            if ( n < 0 )  return 0;
            int result = 1;
            int multiplier = 9;
            n = Math.min(n, 10); //after n > 10 there would be no unique numbers
            for (int i = 1; i <= n; i++) {
                result += multiplier;
                multiplier *= (10-i); //for each extra exponent you will have one digit repeated for sure
            }
            return result;
    }
}
