class Solution {
  
    int rec(int sLevel, int tLevel, String s, String t, int dp[][]) {
    
        // pruning
        if (tLevel == t.length()) {
        
            return 1;
        }
        
        // base case
        if (sLevel == s.length()) {
            
            return 0;
        }
        
        // cache check
        if (dp[sLevel][tLevel] != -1) {
        
            return dp[sLevel][tLevel];
        }
        
        // compute
        int ans = 0;
        
        ans += rec(sLevel + 1, tLevel, s, t, dp);
        if (s.charAt(sLevel) == t.charAt(tLevel)) {
        
            ans += rec(sLevel + 1, tLevel + 1, s, t, dp);
        }
        
        // save and return
        return dp[sLevel][tLevel] = ans;
    }
    public int numDistinct(String s, String t) {
        
        int n = s.length(), m = t.length();
        
        int dp[][] = new int[n][m];
        for (int i=0; i<n; i++) {
            
            Arrays.fill(dp[i], -1);
        }
        
        return rec(0, 0, s, t, dp);
    }
}