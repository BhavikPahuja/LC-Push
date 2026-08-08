
class Solution {
    public int[] validSequence(String word1, String word2) {
        
        int n = word1.length(), m = word2.length();
        int[] dp = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
        
            dp[i] = dp[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
        
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        int k = 0;
        int i = 0;

        while (i < n && k < m) {

            if (word1.charAt(i) == word2.charAt(k)) {
        
                ans[k++] = i;
            }

            else if (dp[i + 1] >= m - k - 1) {
        
                ans[k++] = i;

                i++;

                while (i < n && k < m) {
        
                    if (word1.charAt(i) == word2.charAt(k)) {
        
                        ans[k++] = i;
                    }
                    i++;
                }

                break;
            }

            i++;
        }

        return k == m ? ans : new int[0];
    }
}