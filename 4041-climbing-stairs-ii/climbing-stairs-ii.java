class Solution {
    public int climbStairs(int n, int[] costs) {
        
        int p1 = 0, p2 = (int) 1e9, p3 = (int) 1e9;
        
        for (int i = 1; i <= n; i++) {
        
            int temp = Math.min(p1 + 1, Math.min(p2 + 4, p3 + 9));
            int curr = temp + costs[i - 1];
            p3 = p2;
            p2 = p1;
            p1 = curr;
        }
        
        return p1;
    }
}