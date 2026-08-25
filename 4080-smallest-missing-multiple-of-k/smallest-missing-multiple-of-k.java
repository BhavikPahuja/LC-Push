class Solution {

    public int missingMultiple(int[] nums, int k) {

        Set<Integer> seen = new HashSet<>();

        for (int i : nums) {

            seen.add(i);
        }

        for (int i=1; i<=101; i++) {

            if (!seen.contains(i * k)) {

                return i * k;
            }
        }

        return -1;
    }
}