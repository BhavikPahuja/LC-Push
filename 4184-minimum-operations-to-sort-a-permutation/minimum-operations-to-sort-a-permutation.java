class Solution {

    public int minOperations(int[] nums) {
    
        int i = 0, j = 0, n = nums.length;
    
        for (int x=1; x<n; x++) {
    
            i += (nums[x] == (nums[x-1] + 1) % n) ? 1 : 0;
            j += (nums[x-1] == (nums[x] + 1) % n) ? 1 : 0;
        }

        if (i == n - 1 && nums[0] == 0) {

            return 0;
        }

        if (i == n - 1) {
            
            int left = n - nums[0];
            int right = nums[n-1] + 1 + 2;
            
            return Math.min(right, left);
        } else if (j == n - 1) {
            
            int left = n - nums[n-1] + 1;
            int right = (nums[0] + 1) % n + 1;
            
            return Math.min(right, left);
        }

        return -1;
    }
}