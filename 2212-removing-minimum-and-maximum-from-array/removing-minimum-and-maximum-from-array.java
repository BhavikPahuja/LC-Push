class Solution {
    
    public int minimumDeletions(int[] nums) {
    
        int n = nums.length;

        int min_idx = 0;
        int max_idx = 0;

        for (int i = 1; i < n; i++) {
    
            if (nums[i] < nums[min_idx]) {
    
                min_idx = i;
            }

            if (nums[i] > nums[max_idx]) {
    
                max_idx = i;
            }
        }

        if (min_idx > max_idx) {
    
            int temp = min_idx;
            min_idx = max_idx;
            max_idx = temp;
        }

        int left = max_idx + 1, right = n - min_idx, both = (min_idx + 1) + (n - max_idx);
        return Math.min(left, Math.min(right, both));
    }
}