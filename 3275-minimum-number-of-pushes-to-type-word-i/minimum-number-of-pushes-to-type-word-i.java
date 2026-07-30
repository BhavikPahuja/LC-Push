class Solution {
    public int minimumPushes(String word) {
        
        int mul = 1;
        int n = word.length();
        int ans = 0;

        while (n > 0) {

            ans += Math.min(n, 8) * mul;
            n -= 8;
            mul++;
        }

        return ans;
    }
}