class Solution {

    public int minGroups(int[][] iv) {

        int n = iv.length;

        int a[][] = new int[2 * n][2];
    
        for (int i = 0; i < n; i++) {
     
            a[2 * i][0] = iv[i][0];
            a[2 * i][1] = 0;

            a[2 * i + 1][0] = iv[i][1];
            a[2 * i + 1][1] = 1;
        }

        Arrays.sort(a, (x, y) -> {int cmp = Integer.compare(x[0], y[0]); return cmp != 0 ? cmp : Integer.compare(x[1], y[1]);});

        int cnt = 0, ans = 0;

        for (int i=0; i<2*n; i++) {

            System.out.println(a[i][0] + " " + a[i][1]);
        }

        for (int i[] : a) {

            if (i[1] == 0) {

                cnt++;
            } else {

                cnt--;
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}