class Solution {
    public int maxProduct(int[] nums) {
        
        int m1 = - (int) 1e9;
        int m2 = - (int) 1e9;

        for (int i : nums) {

            if (i > m1) {

                m2 = m1;
                m1 = i;
            } else if (i > m2) {

                m2 = i;
            }
        }

        return (m1 - 1) * (m2 - 1);
    }
}