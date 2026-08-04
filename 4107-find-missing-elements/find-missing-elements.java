class Solution {

    public List<Integer> findMissingElements(int[] nums) {

        int min = (int) 1e9, max = - (int) 1e9;
        Set<Integer> seen = new HashSet<>();

        for (int i : nums) {

            min = Math.min(min, i);
            max = Math.max(max, i);

            seen.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
    
        for (int i=min; i<=max; i++) {

            if (!seen.contains(i)) {

                ans.add(i);
            }
        }

        return ans;
    }
}