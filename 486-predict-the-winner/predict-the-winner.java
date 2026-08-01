class Solution {
    private int rec(int left, int right, int[] nums, int[][] dp) {
        
        if (left == right) {
            
            return nums[left];
        }

        if (dp[left][right] != -1) {
            
            return dp[left][right];
        }

        int takeLeft = nums[left] - rec(left + 1, right, nums, dp);
        int takeRight = nums[right] - rec(left, right - 1, nums, dp);

        dp[left][right] = Math.max(takeLeft, takeRight);
        return dp[left][right];
    }

    public boolean predictTheWinner(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i=0; i<n; i++) {

            Arrays.fill(dp[i], -1);
        }

        return rec(0, n - 1, nums, dp) >= 0;
    }
}