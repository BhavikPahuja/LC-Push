class Solution {

    public int longestMonotonicSubarray(int[] a) {

        

        int ans = 1;
        int iCnt = 1;
        int dCnt = 1;
        int n = a.length;

        for (int i=1; i<n; i++) {

            if (a[i] < a[i-1]) {

                iCnt++;
            } else {

                iCnt = 1;
            }

            if (a[i] > a[i-1]) {

                dCnt++;
            } else {

                dCnt = 1;
            }

            ans = Math.max(ans, Math.max(iCnt, dCnt));
        }

        return ans;
    }
}