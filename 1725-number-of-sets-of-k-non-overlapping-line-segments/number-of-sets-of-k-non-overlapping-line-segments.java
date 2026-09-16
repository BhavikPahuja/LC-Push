class Solution {

    int MOD = (int) 1e9 + 7;

    int[][] dp;
    int[][] suffix;
    int n;

    int getSuffix(int pnt, int cnt) {

        if (pnt >= n) {
            
            return 0;
        }

        if (suffix[pnt][cnt] != -1) {
            
            return suffix[pnt][cnt];
        }

        suffix[pnt][cnt] = (rec(pnt, cnt) + getSuffix(pnt + 1, cnt)) % MOD;

        return suffix[pnt][cnt];
    }

    int rec(int pnt, int cnt) {

        if (cnt == 0) {
            
            return 1;
        }

        if (pnt >= n) {
            
            return 0;
        }

        if (dp[pnt][cnt] != -1) {
            
            return dp[pnt][cnt];
        }

        int ans = rec(pnt + 1, cnt);

        ans = (ans + getSuffix(pnt + 1, cnt - 1)) % MOD;

        return dp[pnt][cnt] = ans;
    }

    public int numberOfSets(int n, int k) {

        this.n = n;

        dp = new int[n + 1][k + 1];
        suffix = new int[n + 1][k + 1];

        for (int[] row : dp) {

            Arrays.fill(row, -1);
        }

        for (int[] row : suffix) {

            Arrays.fill(row, -1);
        }

        return rec(0, k);
    }
}