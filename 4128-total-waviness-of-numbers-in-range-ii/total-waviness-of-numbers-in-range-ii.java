class Solution {
    private String s;
    private long[][][][] memoCnt;
    private long[][][][] memoWave;
    private long[] dfs(int pos, int prevPrev, int prev, int started, int tight) {
        if (pos == s.length()) return new long[]{1, 0};
        if (tight == 0 && memoCnt[pos][prevPrev][prev][started] != -1) return new long[]{memoCnt[pos][prevPrev][prev][started], memoWave[pos][prevPrev][prev][started]};
        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
        long totalCount = 0;
        long totalWave = 0;
        for (int d = 0; d <= limit; d++) {
            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            if (started == 0 && d == 0) {
                long[] nxt = dfs(pos + 1, 10, 10, 0, nextTight);
                totalCount += nxt[0];
                totalWave += nxt[1];
            } else {
                int add = 0;
                if (started == 1 && prevPrev != 10) {
                    boolean peak = prev > prevPrev && prev > d;
                    boolean valley = prev < prevPrev && prev < d;
                    if (peak || valley) add = 1;
                }
                int newPrevPrev = (started == 0) ? 10 : prev;
                int newPrev = d;
                long[] nxt = dfs(pos + 1, newPrevPrev, newPrev, 1, nextTight);
                totalCount += nxt[0];
                totalWave += nxt[1] + add * nxt[0];
            }
        }
        if (tight == 0) {
            memoCnt[pos][prevPrev][prev][started] = totalCount;
            memoWave[pos][prevPrev][prev][started] = totalWave;
        }
        return new long[]{totalCount, totalWave};
    }
    private long rec(long x) {
        if (x <= 0) return 0;
        s = String.valueOf(x);
        int n = s.length();
        memoCnt = new long[n][11][11][2];
        memoWave = new long[n][11][11][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    for (int t = 0; t < 2; t++) {
                        memoCnt[i][j][k][t] = -1;
                        memoWave[i][j][k][t] = -1;
                    }
                }
            }
        }
        return dfs(0, 10, 10, 0, 1)[1];
    }
    public long totalWaviness(long num1, long num2) {
        return rec(num2) - rec(num1 - 1);
    }
}