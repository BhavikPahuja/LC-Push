class Solution {

    long MOD = (int) 1e9 + 7;
    int MAX = 100001;
    long pow10[] = new long[MAX];

    public int[] sumAndMultiply(String s, int[][] queries) {

        pow10[0] = 1;
        for (int i = 1; i < MAX; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int n = s.length();

        int prefix[] = new int[n + 1];
        int conn[] = new int[n + 1];
        long val[] = new long[n + 1];

        prefix[0] = 0;
        conn[0] = 0;
        val[0] = 0;

        for (int i = 0; i < n; i++) {

            int x = s.charAt(i) - '0';

            prefix[i + 1] = prefix[i] + x;

            if (x != 0) {
                val[i + 1] = (val[i] * 10 + x) % MOD;
                conn[i + 1] = conn[i] + 1;
            } else {
                val[i + 1] = val[i];
                conn[i + 1] = conn[i];
            }
        }

        int m = queries.length;
        int ans[] = new int[m];

        for (int i = 0; i < m; i++) {

            int l = queries[i][0];
            int r = queries[i][1] + 1;

            int curr_sum = prefix[r] - prefix[l];

            int len = conn[r] - conn[l];

            long curr_val = (val[r] - (val[l] * pow10[len]) % MOD + MOD) % MOD;

            long curr_ans = (curr_val * curr_sum) % MOD;

            ans[i] = (int) curr_ans;
        }

        return ans;
    }
}