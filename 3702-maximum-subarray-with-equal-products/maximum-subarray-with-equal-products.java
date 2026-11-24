class Solution {
  
    public long gcd(long a, long b) {
  
        if (b == 0) {

            return a;
        }
        
        return gcd(b, a % b);
    }

    public int maxLength(int[] nums) {
        
        int n = nums.length;
        int max = 0;

        for (int i=0; i<n; i++) {
            
            long gcd = 0, lcm = 1;
            long mul = 1;

            for (int j=i; j<n; j++) {
                
                mul *= nums[j];

                gcd = gcd(gcd, nums[j]);
                lcm = (lcm / gcd(lcm, nums[j])) * nums[j];

                if(mul == gcd * lcm) {
                
                    max = Math.max(max, j-i+1);
                }
            }
        }

        return max;
    }
} 