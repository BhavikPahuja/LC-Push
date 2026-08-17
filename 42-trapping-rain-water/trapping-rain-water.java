class Solution {

    public int trap(int[] height) {

        int n = height.length;

        int prefix[] = new int[n + 1];
        int suffix[] = new int[n + 1];

        prefix[0] = -1;
        suffix[n] = -1;

        int max = -1;
        for (int i=0; i<n; i++) {

            max = Math.max(max, height[i]);
            prefix[i + 1] = Math.max(prefix[i], max);
        }

        max = -1;
        for (int i=n-1; i>=0; i--) {

            max = Math.max(max, height[i]);
            suffix[i] = Math.max(suffix[i + 1], max);
        }

        int ans = 0;

        for (int i=0; i<n; i++) {

            ans += Math.max(0, Math.min(prefix[i], suffix[i + 1]) - height[i]);
        }

        return ans;
    }
}