class Solution {

    public int missingInteger(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {

            seen.add(num);
        }

        int sum = nums[0];
        int n = nums.length;

        for (int i=1; i<n; i++) {

            if (nums[i] != nums[i - 1] + 1) {

                break;
            }

            sum += nums[i];
        }

        while (seen.contains(sum)) {

            sum++;
        }

        return sum;
    }
}