import java.math.BigInteger;

class Solution {
    public int findGCD(int[] nums) {
        
        int max = - (int) 1e9;
        int min = (int) 1e9;

        for (int num : nums) {

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return BigInteger.valueOf(max).gcd(BigInteger.valueOf(min)).intValue();
    }
}