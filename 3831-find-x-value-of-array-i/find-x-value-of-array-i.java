class Solution {
    
    long rec(int i, int prev, int req, int k, int n, int nums[], long dp[][]) {

        if (i >= n) {

            return 0;
        }

        if (dp[i][prev] != -1) {

            return dp[i][prev];
        }

        long ans = 0;

        if (prev == k) {

            ans += rec(i + 1, k, req, k, n, nums, dp);
        }

        long curr = 0;

        if (prev == k) {

            curr = nums[i];
        } else {

            curr = ((long) prev * nums[i]) % k;
        }

        ans += curr == req ? 1 : 0;
        ans += rec(i + 1, (int) curr, req, k, n, nums, dp);

        return dp[i][prev] = ans;
    }

    public long[] resultArray(int[] nums, int k) {

        int n = nums.length;

        for (int i=0; i<n; i++) {

            nums[i] %= k;
        }

        long ans[] = new long[k];

        for (int i=0; i<k; i++) {

            long dp[][] = new long[n][k+1];

            for (long row[] : dp) {

                Arrays.fill(row, -1);
            }

            ans[i] = rec(0, k, i, k, n, nums, dp);
        }

        return ans;
    }
}