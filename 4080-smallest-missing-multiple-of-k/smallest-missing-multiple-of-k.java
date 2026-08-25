class Solution {

    public int missingMultiple(int[] nums, int k) {
    
        Set<Integer> seen = new HashSet<>();
        for (int i : nums) {

            seen.add(i);
        }

        for(int i=k; ; i+=k){
    
            if(!seen.contains(i)){
    
                return i;
            }
        }
    }
}