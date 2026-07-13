class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int i = 0, j = 0;
        Set<Integer> seen = new HashSet<>();

        int n = nums.length;

        for (j=0; j<Math.min(k + 1, n); j++) {

            if (seen.contains(nums[j])) {

                return true;
            }

            seen.add(nums[j]);
        }

        while (j < n) {

            seen.remove(nums[i]);

            if (seen.contains(nums[j])) {

                return true;
            }

            seen.add(nums[j]);

            i++;
            j++;
        }

        return false;
    }
}