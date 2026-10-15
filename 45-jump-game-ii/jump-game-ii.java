class Solution {

    public int jump(int[] nums) {

        int n = nums.length;

        int max[] = new int[n];
        Arrays.fill(max, (int) 1e9);
        max[0] = 0;

        for (int i=0; i<n; i++) {

            for (int j=1; j<=nums[i] && i+j < n; j++) {

                max[i + j] = Math.min(max[i + j], max[i] + 1);
            }
        }

        return max[n - 1];
    }
}