class Solution {
    
    public int eraseOverlapIntervals(int[][] iv) {

        int n = iv.length;

        Arrays.sort(iv, (a, b) -> Integer.compare(a[1], b[1]));

        int cnt = 1;
        int end = iv[0][1];

        for (int i=1; i<n; i++) {

            if (iv[i][0] >= end) {

                cnt++;
                end = iv[i][1];
            }
        }

        return n - cnt;
    }
}