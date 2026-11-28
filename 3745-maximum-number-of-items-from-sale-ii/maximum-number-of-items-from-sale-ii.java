class Solution {
    
    public int maximumSaleItems(int[][] items, int budget) {
    
        int n = items.length;
        long cnt[] = new long[n + 1];
        long g[] = new long[n + 1];
        long m = Long.MAX_VALUE, r = budget;
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
        
            cnt[items[i][0]]++;
            m = Math.min(m, (long) items[i][1]);
        }
        
        for (int v = 1; v <= n; v++) {
        
            for (int k = v; k <= n; k += v) {

                g[v] += cnt[k];
            }
        }
        
        long a[][] = new long[n][2];
        
        for (int i = 0; i < n; i++) {
        
            a[i][0] = items[i][1];
            a[i][1] = items[i][0];
        }
        
        Arrays.sort(a, (u, w) -> u[0] != w[0] ? Long.compare(u[0], w[0]) : Long.compare(u[1], w[1]));
        
        for (int i = 0; i < n; i++) {
        
            long p = a[i][0], x = g[(int) a[i][1]] - 1;
        
            if (p >= 2 * m) {

                break;
            }
        
            long t = Math.min(x, r / p);
            
            r -= t * p;
            ans += 2 * t;
            
            if (t < x) {

                break;
            }
        }
        
        return (int) (ans + r / m);
    }
}