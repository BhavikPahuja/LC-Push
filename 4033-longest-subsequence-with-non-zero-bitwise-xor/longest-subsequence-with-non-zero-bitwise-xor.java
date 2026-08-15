class Solution {

    public int longestSubsequence(int[] nums) {
 
        int n = nums.length;
        int xor = 0;
        boolean z = true;

        for (int i : nums) {
            
            xor ^= i;
            
            if (i > 0) {
            
                z = false;
            }
        }
        
        if (xor > 0) {
        
            return n;
        }

        return z ? 0 : n - 1;
    }
}