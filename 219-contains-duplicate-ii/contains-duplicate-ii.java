class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int i = 0, j = 0;
        Set<Integer> seen = new HashSet<>();

        int n = nums.length;

        for (int x=0; x<Math.min(k + 1, n); x++) {

            if (seen.contains(nums[x])) {

                return true;
            }

            seen.add(nums[x]);
            j++;
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