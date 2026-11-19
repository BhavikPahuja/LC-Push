class Solution {
    public int minimizeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;

        int p1 = nums[n - 1] - nums[2];
        int p2 = nums[n - 2] - nums[1];
        int p3 = nums[n - 3] - nums[0];

        return Math.min(p1, Math.min(p2, p3));
    }
}