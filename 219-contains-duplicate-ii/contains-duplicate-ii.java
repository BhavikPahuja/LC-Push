class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int i = 0, j = 0;
        Map<Integer, Integer> seen = new HashMap<>();

        int n = nums.length;

        for (int x=0; x<Math.min(k + 1, n); x++) {

            if (seen.containsKey(nums[x])) {

                return true;
            }

            seen.put(nums[x], 1);
            j++;
        }

        while (j < n) {

            seen.put(nums[i], seen.get(nums[i]) - 1);
            if (seen.get(nums[i]) < 1) {

                seen.remove(nums[i]);
            }

            if (seen.containsKey(nums[j])) {

                return true;
            }

            seen.put(nums[j], 1);

            i++;
            j++;
        }

        return false;
    }
}