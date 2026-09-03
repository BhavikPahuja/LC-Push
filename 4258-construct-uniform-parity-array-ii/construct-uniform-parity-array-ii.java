class Solution {
    
    public boolean uniformArray(int[] nums1) {
    
        int min = (int) 1e9;;
    
        for (int num : nums1){
    
            min = Math.min(min, num);
        }
    
        if (min % 2 == 1){
    
            return true;
        }
    
        for (int num : nums1){
    
            if (num % 2 == 1){
    
                return false;
            }
        }
    
        return true;
    }
}