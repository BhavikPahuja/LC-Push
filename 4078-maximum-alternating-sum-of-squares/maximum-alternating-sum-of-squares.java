class Solution {
    
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        long sq[] = new long[n];
        long total = 0L;
    
        for (int i=0; i<n; i++) {
    
            sq[i] = nums[i] * nums[i];
            total += sq[i];
        }
    
        Arrays.sort(sq);
        int k = n/2;
        long small = 0L;
    
        for (int i=0; i<k; i++) {

            small += sq[i];
        }
    
        return total - 2L * small;
    }
}