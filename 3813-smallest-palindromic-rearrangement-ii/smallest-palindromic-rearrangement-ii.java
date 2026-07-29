class Solution {

    private static final int INF = 1000001;
    private static final int N = 24;
    private static final int[][] C = new int[N][N];
    private static boolean pascalInitialized = false;
    
    private static void initPascal() {
        
        if (pascalInitialized) {

            return;
        }
        pascalInitialized = true;

        C[0][0] = 1;

        for (int i = 1; i < N; i++) {
            
            C[i][0] = C[i][i] = 1;
            
            for (int j = 1; j <= i / 2; j++) {
                
                C[i][j] = C[i][i - j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    private int comb(int n, int k) {
        
        if (n < N && k < N && n >= 0 && k >= 0 && k <= n) {

            return C[n][k];
        }

        if (k < 0 || k > n) {

            return 0;
        }
        
        if (2 * k > n) {

            k = n - k;
        }

        long ans = 1;
        
        for (int i = 1; i <= k; i++) {
            
            ans = ans * (n - i + 1) / i;
            
            if (ans >= INF) {

                return INF;
            }
        }
        
        return (int) ans;
    }

    private int perm(int[] count, int sz) {
        
        long ans = 1;
        
        for (int f : count) {
            if (f == 0) {

                continue;
            }
            
            ans *= comb(sz, f);
            
            if (ans >= INF) {

                return INF;
            }
            
            sz -= f;
        }
        
        return (int) ans;
    }

    public String smallestPalindrome(String S, long K) {
        
        initPascal();
        int n = S.length();
        
        char[] ans = new char[n];
        Arrays.fill(ans, ' ');

        int[] count = new int[26];
        int n0 = n / 2;
        
        for (int i = 0; i < n0; i++) {
            
            count[S.charAt(i) - 'a']++;
        }

        if (n % 2 == 1) {
            
            ans[n / 2] = S.charAt(n / 2);
        }

        long total = perm(count, n0);
        if (K > total) {

            return "";
        }

        int index = 0;
        int sz = n0;

        for (int i = 0; i < n0; i++) {
            
            boolean placed = false;
            
            for (int c = 0; c < 26; c++) {
                
                if (count[c] == 0) {

                    continue;
                }

                count[c]--;
                sz--;
                
                long cnt = perm(count, sz);

                if (cnt >= K) {

                    ans[index] = ans[n - 1 - index] = (char) ('a' + c);
                    index++;
                    placed = true;
                    break;
                } else {

                    K -= cnt;
                    count[c]++;
                    sz++;
                }
            }
            if (!placed) {

                break;
            }
        }

        return new String(ans);
    }
}