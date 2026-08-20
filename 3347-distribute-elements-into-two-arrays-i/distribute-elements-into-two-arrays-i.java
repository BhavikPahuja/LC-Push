class Solution {

    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int a[] = new int[n];
        int b[] = new int[n];
    
        a[0] = nums[0];
        b[0] = nums[1];

        int j = 1, k = 1;
        for (int i=2; i<n; i++) {

            if (a[j - 1] > b[k - 1]) {

                a[j++] = nums[i];
            } else {

                b[k++] = nums[i];
            }
        }

        for (int i=0; i<k; i++) {

            a[j + i] = b[i];
        }

        return a;
    }
}